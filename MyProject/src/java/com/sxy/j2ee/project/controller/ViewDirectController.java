/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.controller;

import com.sxy.j2ee.project.model.Book;
import com.sxy.j2ee.project.model.BookDaoImpl;
import com.sxy.j2ee.project.model.Comment;
import com.sxy.j2ee.project.model.CommentDaoImpl;
import com.sxy.j2ee.project.model.User;
import com.sxy.j2ee.project.security.Md5;
import java.util.ArrayList;
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

    private CommentDaoImpl cdi;
    private BookDaoImpl bdi;

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
    public ModelAndView book(String bookId, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
        if(bookId == "")
            bookId = request.getParameter(bookId);
	Book book = bdi.findBookById(bookId);
	ArrayList<Comment> comments = cdi.getCommentsByBookId(bookId);
	request.setAttribute("book", book);
	request.setAttribute("comments", comments);
	mav.addObject("comment", new Comment());
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
	ModelAndView mav = new ModelAndView("login");
	mav.addObject("user", new User());
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

    @RequestMapping(value = "/addBook")
    public ModelAndView addBook() {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("addBook");
	mav.addObject("book", new Book());
	return mav;
    }

    @RequestMapping(value = "/addBookAction")
    public ModelAndView addBookAction(Book book) {
	ModelAndView mav = new ModelAndView("addBook");
	mav.addObject("book", new Book());
	book.setId(Md5.Md5_16(book.getAuthor() + book.getTitle()));
	book.setCoverPath(book.getId());
	if (bdi.insert(book)) {
	    return mav;
	} else {
	    mav.setViewName("error");
	}
	return mav;
    }

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
	ModelAndView mav = new ModelAndView("hello");
	return mav;
    }
    
    @RequestMapping(value = "/search")
    public ModelAndView search(HttpServletRequest request)  {
        ModelAndView mav = new ModelAndView();
        String query = request.getParameter("query");
        ArrayList<Book> books = bdi.findBooksByTitle(query);
        request.setAttribute("books", books);
        mav.addObject("query", query);
        mav.setViewName("searchResult");
        return mav;
    }

    public void setCdi(CommentDaoImpl cdi) {
	this.cdi = cdi;
    }

    public void setBdi(BookDaoImpl bdi) {
	this.bdi = bdi;
    }
}
