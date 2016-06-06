/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.controller;

import com.sxy.j2ee.project.model.Book;
import com.sxy.j2ee.project.model.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Y400
 */
@Controller
public class ViewDirectController {

    private final String[] genders = {"男", "女", "保密"};

    /**
     * 处理首页请求
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index() {
	ModelAndView mav = new ModelAndView("index");
	return mav;
    }

    @RequestMapping(value = "/test")
    public ModelAndView test() {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("register");
	return mav;
    }

    /**
     * 处理对book.htm的请求，bookId是传入的参数
     *
     * @param bookId
     * @return
     */
    @RequestMapping(value = "/book")
    public ModelAndView book(String bookId) {
	ModelAndView mav = new ModelAndView();
	Book book =new Book();
        book.setTitle("123123");
        book.setAuthor("asdasd");
        book.setSummary("qwe");
	mav.addObject("book", book);
//	mav.addObject("comments", comments);
	mav.setViewName("bookpage");
	return mav;
    }

    /**
     * 响应login.htm的请求 返回login页面和参数user
     *
     * @return
     */
    @RequestMapping(value = {"/login"})
    public ModelAndView login() {
	ModelAndView mav = new ModelAndView("login", "user", new User());
	return mav;
    }

    /**
     * 响应register.htm的请求，返回register.jsp
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/register")
    public ModelAndView register(HttpServletRequest request) {
	ModelAndView mav;
	mav = new ModelAndView("register", "user", new User());
	mav.addObject("genders", genders);
	return mav;

    }
}
