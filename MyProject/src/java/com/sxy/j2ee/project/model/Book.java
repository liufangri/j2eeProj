/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.model;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Y400
 */
public class Book {

    private String title;
    private String summary;
    private String author;
    private String id;
    private Date publishDate;
    private String coverPath;
    private String[] tags;
    private MultipartFile coverImg;
    private String briefSummary;

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getSummary() {
	return summary;
    }

    public void setSummary(String summary) {
	if (summary.length() > 100) {
	    setBriefSummary(summary.substring(0, 120) + "...");
	} else {
	    setBriefSummary(summary);
	}
	this.summary = summary;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Date getPublishDate() {
	return publishDate;
    }

    public void setPublishDate(Date publishDate) {
	this.publishDate = publishDate;
    }

    public String getCoverPath() {
	return coverPath;
    }

    public void setCoverPath(String coverPath) {
	this.coverPath = coverPath;
    }

    public String[] getTags() {
	return tags;
    }

    public void setTags(String[] tags) {
	this.tags = tags;
    }

    public MultipartFile getCoverImg() {
	return coverImg;
    }

    public void setCoverImg(MultipartFile coverImg) {
	this.coverImg = coverImg;
    }

    public String getBriefSummary() {
	return briefSummary;
    }

    public void setBriefSummary(String briefSummary) {
	this.briefSummary = briefSummary;
    }
}
