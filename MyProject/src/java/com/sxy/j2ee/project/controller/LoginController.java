/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.controller;

import com.sxy.j2ee.project.model.Book;
import com.sxy.j2ee.project.model.BookDaoImpl;
import com.sxy.j2ee.project.model.User;
import com.sxy.j2ee.project.model.UserDaoImpl;
import com.sxy.j2ee.project.security.Md5;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 涉及login操作的控制类
 *
 * @author Y400
 */
@Controller
public class LoginController {

    private UserDaoImpl userDaoImpl;
    private BookDaoImpl bdi;

    private final String error_email = "error_email";
    private final String error_password = "error_password";
    private final String error = "has-error";

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
	this.userDaoImpl = userDaoImpl;
    }

    /**
     * 响应loginAction.htm的请求 如果登录成功，返回主页，如果登录失败，返回登录页
     *
     * @param session
     * @param user
     * @return
     */
    @RequestMapping(value = {"/loginAction"})
    public ModelAndView loginAction(HttpSession session, User user, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	String email = user.getEmail();
	if (email == null || email == "") {
	    mav.addObject(error_email, "请填入邮箱");
	    mav.addObject("email_has_error", error);
	} else if (!email.contains("@") || email.indexOf("@") < 1 || !email.contains(".") || email.indexOf(".") - email.indexOf("@") < 1 || email.length() - email.indexOf(".") < 2) {
	    mav.addObject(error_email, "邮箱格式不正确，请确认后再输入");
	    mav.addObject("email_has_error", error);
	} else {
	    String password = user.getPassword();
	    User queryUser = userDaoImpl.findByEmail(email);

	    if (password == null || password == "") {
		mav.addObject(error_password, "密码不能为空");
		mav.addObject("password_has_error", error);
	    } else if (queryUser == null) {
		mav.addObject(error_email, "查询不到邮箱");
		mav.addObject("email_has_error", error);
	    } else if (!queryUser.getPwMd5().equals(Md5.Md5_16(password))) {
		mav.addObject(error_password, "密码错误");
		mav.addObject("password_has_error", error);
	    } else {
		//密码验证成功
		request.getRequestURI();
		mav.setViewName("index");
		ArrayList<Book> books = bdi.getBooksForIndex();
		request.setAttribute("books", books);
		session.setAttribute("user", queryUser);
		session.setAttribute("login_state", true);
		return mav;
	    }

	}
	mav.setViewName("login");
	return mav;

    }

    /**
     * 响应logout.htm的请求，设置登录状态并返回主页
     *
     * @param session
     * @return
     */
    @RequestMapping(value = {"/logout"})
    public ModelAndView logout(HttpSession session) {
	session.setAttribute("login_state", false);
	return new ModelAndView("index");
    }

    public void setBdi(BookDaoImpl bdi) {
	this.bdi = bdi;
    }
}
