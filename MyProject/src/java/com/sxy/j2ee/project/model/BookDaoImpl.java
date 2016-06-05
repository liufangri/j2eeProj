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
 * 书籍的数据库操作对象
 *
 * @author Y400
 */
public class BookDaoImpl implements BookDao {

    private DbcpBean dbcpBean;

    @Override
    public Book findBookById(String id) {
	Book book = null;
	Connection connection = dbcpBean.getConnection();
	String sql = "select * from book where id = ?";
	PreparedStatement ps;
	try {
	    ps = connection.prepareStatement(sql);
	    ps.setString(1, id);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		book = new Book();
		book.setId(rs.getString("id"));
		book.setAuthor(rs.getString("author"));
		book.setPublishDate(rs.getDate("publishDate"));
		book.setTitle(rs.getString("title"));
		book.setCoverPath(rs.getString("coverPath"));
		book.setSummary(rs.getString("summary"));
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    return book;
	}
    }

    @Override
    public Book findBookByTitle(String title) {
	Book book = null;
	Connection connection = dbcpBean.getConnection();
	String sql = "select * from book where title = ?";
	PreparedStatement ps;
	try {
	    ps = connection.prepareStatement(sql);
	    ps.setString(1, title);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		book = new Book();
		book.setId(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setPublishDate(rs.getDate("publishDate"));
		book.setTitle(rs.getString("title"));
		book.setCoverPath(rs.getString("coverPath"));
		book.setSummary(rs.getString("summary"));
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    return book;
	}
    }

    @Override
    public Book findBookByAuthor(String author) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Book book) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Book book) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Book book) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDbcpBean(DbcpBean dbcpBean) {
	this.dbcpBean = dbcpBean;
    }

}
