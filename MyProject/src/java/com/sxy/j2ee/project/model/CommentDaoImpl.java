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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Y400
 */
public class CommentDaoImpl implements CommentDao {

    private DbcpBean dbcpBean = null;

    @Override
    public boolean insert(Comment comment) {
	Connection connection = dbcpBean.getConnection();
	String sql = "insert into comment (id,bookId,submitter, content, time) values(?,?,?,?,?)";
	PreparedStatement ps;
	try {
	    ps = connection.prepareStatement(sql);
	    ps.setString(1, comment.getId());
	    ps.setString(2, comment.getBookId());
	    ps.setString(3, comment.getSubmitter());
	    ps.setString(4, comment.getContent());
	    ps.setTimestamp(5, comment.getTime());
	    ps.executeUpdate();
	    return true;
	} catch (SQLException ex) {
	    Logger.getLogger(CommentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
	    return false;
	} finally {
	    dbcpBean.shutDownDataSource();
	}

    }

    @Override
    public List<Comment> getCommentsByBookId(String bookId) {
	List<Comment> comments = new ArrayList<Comment>();
	Connection connection = dbcpBean.getConnection();
	String sql = "select * from comment where bookId = ?";
	PreparedStatement ps;
	try {
	    ps = connection.prepareStatement(sql);
	    ps.setString(1, bookId);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		Comment c = new Comment();
		c.setBookId(bookId);
		c.setId(rs.getString("id"));
		c.setSubmitter(rs.getString("submitter"));
		c.setContent(rs.getString("content"));
		c.setTime(rs.getTimestamp("time"));
		comments.add(c);
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(CommentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
	}
	return comments;
    }

    @Override
    public boolean delete(String id) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDbcpBean(DbcpBean dbcpBean) {
	this.dbcpBean = dbcpBean;
    }

}
