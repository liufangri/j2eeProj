/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.model;

import java.sql.Timestamp;

/**
 *
 * @author Y400
 */
public class Comment {

    private Timestamp time;
    private String submitter;
    private String content;
    private String id;
    private String bookId;

    public Timestamp getTime() {
	return time;
    }

    public void setTime(Timestamp time) {
	this.time = time;
    }

    public String getSubmitter() {
	return submitter;
    }

    public void setSubmitter(String submitter) {
	this.submitter = submitter;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getBookId() {
	return bookId;
    }

    public void setBookId(String bookId) {
	this.bookId = bookId;
    }

}
