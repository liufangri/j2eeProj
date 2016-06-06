/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.controller;

import com.sxy.j2ee.project.model.User;
import com.sxy.j2ee.project.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Y400
 */
@Controller
public class CommentController {

    @RequestMapping(value = "/submit")
    public ModelAndView submitComment(Book book) {
	ModelAndView mav = new ModelAndView("bookpage");
        mav.addObject("book", book);
	return mav;
    }
}
