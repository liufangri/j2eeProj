/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.controller;

import com.sxy.j2ee.project.model.Book;
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

    @RequestMapping(value = "/book")
    public ModelAndView book(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	String bookId = (String) request.getParameter("bookId");
	Book book = new Book();
	book.setId(bookId);
	book.setTitle("冰与火之歌");
	book.setSummary("《冰与火之歌》主要描述了在一片虚构的中世纪世界里所发生的一系列宫廷斗争、疆场厮杀、游历冒险和魔法抗衡的故事。在内容及风格上，《冰与火之歌》是现实生活的一面镜子，人性真实的写照。写作手法上马丁运用了POV（Point-of-View，即“视点人物写作手法”），以轮流交换人物第三人称视点的叙事方式进行描写，从而推动故事的进展。");
	mav.addObject("book", book);
	mav.setViewName("bookpage");
	return mav;
    }

}
