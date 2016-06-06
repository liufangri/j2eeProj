/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.controller;

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

    @RequestMapping(value = "/submitComment")
    public View submitComment(HttpSession session) {
	return new RedirectView("book.htm?bookId=" + (String) session.getAttribute("bookId"));
    }
}
