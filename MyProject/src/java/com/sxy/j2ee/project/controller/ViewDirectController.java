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
import com.sxy.j2ee.project.util.MyModelAndView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private final String error = "has-error";
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
	if (bookId == "") {
	    bookId = request.getParameter(bookId);
	}
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
    public ModelAndView login(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView("login");
	String preUrl = request.getQueryString();
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
    public ModelAndView addBook(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("addBook");
	mav.addObject("book", new Book());
	request.setAttribute("administrators", getAdministrators());
	return mav;
    }

    @RequestMapping(value = "/addBookAction")
    public ModelAndView addBookAction(Book book, HttpServletRequest request, MultipartFile coverImg) throws IOException {
	MyModelAndView mav = new MyModelAndView("addBook");
	request.setAttribute("administrators", getAdministrators());
	mav.addObject("book", book);
	String title = book.getTitle();
	String author = book.getAuthor();
	String summary = book.getSummary();
	if (title == null || title.equals("")) {
	    mav.addObject("title_has_error", error);
	    mav.addObject("error_title", "title不能为空");
	} else if (title.length() > 64) {
	    mav.addObject("title_has_error", error);
	    mav.addObject("error_title", "title最长64个字符");
	} else if (author == null || author.equals("")) {
	    mav.addObject("author_has_error", error);
	    mav.addObject("error_author", "author不能为空");

	} else if (author.length() > 64) {
	    mav.addObject("title_has_error", error);
	    mav.addObject("error_author", "author最长64个字符");
	} else if (summary == null || summary.equals("")) {
	    mav.addObject("summary_has_error", error);
	    mav.addObject("error_summary", "summary不能为空");
	} else if (summary.length() > 1024) {
	    mav.addObject("summary_has_error", error);
	    mav.addObject("error_summary", "summary最长1024个字符");
	} else if (book.getCoverImg().getSize() == 0) {
	    mav.addObject("coverImg_has_error", error);
	    mav.addObject("error_coverImg", "书籍封面不能为空");
	} else if (book.getCoverImg().getSize() > 2048576) {
	    mav.addObject("coverImg_has_error", error);
	    mav.addObject("error_coverImg", "封面图像最大为2MB");
	} else {
	    String fileName = coverImg.getOriginalFilename();
	    String[] nameparts = fileName.split("\\.");
	    if (nameparts[nameparts.length - 1].equals("jpg") || nameparts[nameparts.length - 1].equals("JPG")) {

		book.setId(Md5.Md5_16(book.getAuthor() + book.getTitle()));
		if (bdi.findBookById(book.getId()) == null) {
		    String path = request.getSession().getServletContext().getRealPath("/dist");
		    String coverPath = path + "\\img\\bookcovers";
		    if (nameparts.length <= 0) {
			fileName = book.getId();
		    } else {
			fileName = book.getId() + "." + "jpg";
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
		} else {
		    mav.addObject("title_has_error", error);
		    mav.addObject("error_title", "该书已存在");
		}

	    } else {
		mav.addObject("coverImg_has_error", error);
		mav.addObject("error_coverImg", "书籍封面只能为jpg格式");
	    }
	}
	return mav;
    }

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
	ModelAndView mav = new ModelAndView("hello");
	return mav;
    }

    @RequestMapping(value = "/search")
    public ModelAndView search(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	String query = request.getParameter("query");
	ArrayList<Book> books = bdi.search(query);
	request.setAttribute("books", books);
	mav.addObject("query", query);
	mav.setViewName("searchResult");
	return mav;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView("contact");
	return mav;
    }

    @RequestMapping(value = "about")
    public ModelAndView about(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView("about");
	return mav;
    }

    public void setCdi(CommentDaoImpl cdi) {
	this.cdi = cdi;
    }

    public void setBdi(BookDaoImpl bdi) {
	this.bdi = bdi;
    }

    public ArrayList<String> getAdministrators() {
	Properties properties = new Properties();
	ArrayList<String> administrators = new ArrayList<>();
	try {
	    properties.load(this.getClass().getClassLoader().getResourceAsStream("administrators.properties"));
	    String admString = properties.getProperty("administrators");
	    String[] ads = admString.split(";");
	    System.out.println("");
	    for (String ad : ads) {
		administrators.add(ad);
	    }
	} catch (IOException ex) {
	    Logger.getLogger(ViewDirectController.class.getName()).log(Level.SEVERE, null, ex);
	} catch (NullPointerException exception) {
	    Logger.getLogger(ViewDirectController.class.getName()).log(Level.SEVERE, null, exception);
	}
	return administrators;
    }
}
