/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.model;

import com.sxy.j2ee.project.DB.DbcpBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Y400
 */
public class UserDaoImpl implements UserDao {

    private DbcpBean dbcpBean = null;

    public UserDaoImpl() {
	super();
    }

    @Override
    public boolean insert(User user) {
	Connection connection = dbcpBean.getConnection();
	PreparedStatement preparedStatement;
	String sql = "insert into user(name, pwMd5, email, pNum, age, gender, regDate, summary) values(?,?,?,?,?,?,?,?)";
	try {
	    preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setString(1, user.getName());
	    preparedStatement.setString(2, user.getPwMd5());
	    preparedStatement.setString(3, user.getEmail());
	    preparedStatement.setLong(4, user.getpNum());
	    preparedStatement.setInt(5, user.getAge());
	    preparedStatement.setString(6, user.getGender());
	    preparedStatement.setTimestamp(7, user.getRegDate());
	    preparedStatement.setString(8, user.getSummary());
	    preparedStatement.executeUpdate();
	    return true;
	} catch (SQLException ex) {
	    Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
	    return false;
	} finally {
	    dbcpBean.shutDownDataSource();
	}

    }

    @Override
    public boolean update(User user) {
	return true;
    }

    @Override
    public boolean delete(User user) {
	return true;
    }

    @Override
    public boolean delete(long id) {
	return true;
    }

    @Override
    public User findByName(String name) {
	User user = null;
	Connection c = dbcpBean.getConnection();
	try {

	    PreparedStatement preparedStatement = c.prepareStatement("select * from user where name = ?");
	    preparedStatement.setString(1, name);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    if (resultSet.next()) {
		user = new User();
		user.setName(resultSet.getString("name"));
		user.setPwMd5(resultSet.getString("pwMd5"));
		user.setRegDate(resultSet.getTimestamp("regDate"));
		user.setEmail(resultSet.getString("email"));
		user.setpNum(resultSet.getLong("pNum"));
		user.setAge(resultSet.getInt("age"));
		user.setGender(resultSet.getString("gender"));
		user.setSummary(resultSet.getString("summary"));
	    }
	    c.close();
	} catch (SQLException ex) {
	    Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    dbcpBean.shutDownDataSource();
	    return user;
	}

    }

    @Override
    public User findByEmail(String email) {
	User user = null;
	Connection c = dbcpBean.getConnection();
	if (c == null) {
	    c = dbcpBean.getConnection();
	}
	try {

	    PreparedStatement preparedStatement = c.prepareStatement("select * from user where email = ?");
	    preparedStatement.setString(1, email);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    if (resultSet.next()) {
		user = new User();
		user.setName(resultSet.getString("name"));
		user.setPwMd5(resultSet.getString("pwMd5"));
		user.setRegDate(resultSet.getTimestamp("regDate"));
		user.setEmail(resultSet.getString("email"));
		user.setpNum(resultSet.getLong("pNum"));
		user.setAge(resultSet.getInt("age"));
		user.setGender(resultSet.getString("gender"));
		user.setSummary(resultSet.getString("summary"));
	    }
	    c.close();
	} catch (SQLException ex) {
	    Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    dbcpBean.shutDownDataSource();
	    return user;
	}

    }

    @Override
    public String getPasswordByEmail(String email) {
	String pwMd5 = null;
	Connection connection = dbcpBean.getConnection();
	try {
	    PreparedStatement preparedStatement = connection.prepareStatement("select pwMd5 from user where email=?");
	    preparedStatement.setString(1, email);
	    ResultSet rs = preparedStatement.executeQuery();
	    if (rs.next()) {
		pwMd5 = rs.getString("pwMd5");
	    }
	    connection.close();
	} catch (SQLException ex) {
	    Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    dbcpBean.shutDownDataSource();
	}
	return pwMd5;
    }

    public void setDbcpBean(DbcpBean dbcpBean) {
	this.dbcpBean = dbcpBean;
    }

}
