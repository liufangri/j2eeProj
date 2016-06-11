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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
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
    public ModelAndView index(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView("index");
	ArrayList<Book> books = bdi.getBooksForIndex();
	request.setAttribute("books", books);
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
	Book book = bdi.findBookById(bookId);
	ArrayList<Comment> comments = cdi.getCommentsByBookId(bookId);

	mav.addObject("book", book);
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
    public ModelAndView addBookAction(Book book, HttpServletRequest request, MultipartFile coverImg) throws IOException {
	ModelAndView mav = new ModelAndView("addBook");
	mav.addObject("book", new Book());
	book.setId(Md5.Md5_16(book.getAuthor() + book.getTitle()));
	String path = request.getSession().getServletContext().getRealPath("/dist");
	String coverPath = path + "\\img\\bookcovers";
	String fileName = coverImg.getOriginalFilename();
	String[] nameparts = fileName.split("\\.");
	if (nameparts.length <= 0) {
	    fileName = book.getId();
	} else {
	    fileName = book.getId() + "." + nameparts[nameparts.length - 1];
	}
	File file = new File(coverPath, fileName);

	if (!file.exists()) {
	    file.mkdirs();
	}
	coverImg.transferTo(file);

	book.setCoverPath(file.getAbsolutePath());
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

    public void setCdi(CommentDaoImpl cdi) {
	this.cdi = cdi;
    }

    public void setBdi(BookDaoImpl bdi) {
	this.bdi = bdi;
    }
}
