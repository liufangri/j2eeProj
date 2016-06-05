/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.DB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Y400
 */
public class DbcpBean {

    public class DbcpNotInitException extends Exception {

	public DbcpNotInitException(String message) {
	    super(message);
	}
    }
    private DataSource DS;

    private String url;
    private String userName;
    private String password;
    private String driverClass;
    private int initialSize;
    private int maxTotal;
    private int maxIdle;
    private int maxWaitMillis;
    private int minIdle;
    private Properties prop;
    private String DBConfig = "com/sxy/j2ee/project/DB/DbcpProperties.properties";

    public DbcpBean() {
	initDS();
    }

    public DbcpBean getProperties() {
	try {
	    prop = new Properties();
	    prop.load(this.getClass().getClassLoader().getResourceAsStream(DBConfig));
	    url = prop.getProperty("Url");
	    userName = prop.getProperty("userName");
	    password = prop.getProperty("password");
	    driverClass = prop.getProperty("driverClass");
	    initialSize = Integer.parseInt(prop.getProperty("initialSize"));
	    maxTotal = Integer.parseInt(prop.getProperty("maxTotal"));
	    maxIdle = Integer.parseInt(prop.getProperty("maxIdle"));
	    maxWaitMillis = Integer.parseInt(prop.getProperty("maxWaitMillis"));
	    minIdle = Integer.parseInt(prop.getProperty("minIdle"));

	} catch (IOException ex) {
	    Logger.getLogger(DbcpBean.class.getName()).log(Level.SEVERE, null, ex);
	}
	return this;
    }

    public DataSource getDataSource() {
	return DS;
    }

    public Connection getConnection() {
	Connection connection = null;
	if (DS != null) {
	    try {
		if (((BasicDataSource) DS).isClosed()) {
		    initDS();
		}
		connection = DS.getConnection();

	    } catch (SQLException ex) {
		Logger.getLogger(DbcpBean.class.getName()).log(Level.SEVERE, null, ex);
	    }

	}
	return connection;
    }

    public void shutDownDataSource() {
	try {
	    ((BasicDataSource) DS).close();
	} catch (SQLException ex) {
	    Logger.getLogger(DbcpBean.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public DbcpBean initDS() {
	if (DS == null) {
	    getProperties().initDS(url, userName, password, driverClass, initialSize, maxTotal, maxIdle, maxWaitMillis, minIdle);
	}
	if (((BasicDataSource) DS).isClosed()) {
	    initDS(url, userName, password, driverClass, initialSize, maxTotal, maxIdle, maxWaitMillis, minIdle);
	}
	return this;
    }

    /**
     *
     * @param Url
     * @param userName
     * @param password
     * @param driverClass
     * @param initialSize
     * @param maxTotal
     * @param maxIdle
     * @param maxWaitMillis
     * @param minIdle
     */
    public void initDS(String Url, String userName, String password, String driverClass,
	    int initialSize, int maxTotal, int maxIdle, int maxWaitMillis, int minIdle) {
	BasicDataSource ds = new BasicDataSource();
	ds.setDriverClassName(driverClass);
	ds.setUsername(userName);
	ds.setPassword(password);
	ds.setUrl(Url);
	ds.setInitialSize(initialSize);
	ds.setMaxTotal(maxTotal);
	ds.setMaxIdle(maxIdle);
	ds.setMaxWaitMillis(maxWaitMillis);
	ds.setMinIdle(minIdle);
	DS = ds;
    }

}
