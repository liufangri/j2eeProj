/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.controller;

import com.sxy.j2ee.project.model.Comment;
import com.sxy.j2ee.project.model.CommentDaoImpl;
import com.sxy.j2ee.project.model.User;
import com.sxy.j2ee.project.security.Md5;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Y400
 */
@Controller
public class CommentController {

    private CommentDaoImpl cdi;

    @RequestMapping(value = "/submitComment")

    public View submitComment(HttpSession session, Comment comment) {
	User user = (User) session.getAttribute("user");
	String content = comment.getContent();
	if (content == null || comment.equals("")) {

	} else {
	    comment.setSubmitter(user.getName());
	    long time = new Date().getTime();
	    comment.setTime(new Timestamp(time));
	    comment.setId(Md5.Md5_16(comment.getBookId() + user.getName() + time + content));
	    if (cdi.insert(comment)) {

	    } else {

	    }
	}
	return new RedirectView("book.htm?bookId=" + comment.getBookId());
    }

    public void setCdi(CommentDaoImpl cdi) {
	this.cdi = cdi;
    }
}
