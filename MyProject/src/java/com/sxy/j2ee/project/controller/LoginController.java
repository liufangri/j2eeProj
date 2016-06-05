/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.controller;

import com.sxy.j2ee.project.model.User;
import com.sxy.j2ee.project.model.UserDaoImpl;
import com.sxy.j2ee.project.security.Md5;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Y400
 */
@Controller
public class LoginController {

    private UserDaoImpl userDaoImpl;
    private final String error_email = "error_email";
    private final String error_password = "error_password";
    private final String error = "has-error";

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
	this.userDaoImpl = userDaoImpl;
    }

    @RequestMapping(value = {"/login"})
    public ModelAndView login() {
	ModelAndView mav = new ModelAndView("login", "user", new User());
	return mav;
    }

    @RequestMapping(value = {"/loginAction"})
    public ModelAndView loginAction(HttpSession session, User user) {
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
		mav.setViewName("index");
		session.setAttribute("user", queryUser);
		session.setAttribute("login_state", true);
		return mav;
	    }

	}
	mav.setViewName("login");
	return mav;

    }

    @RequestMapping(value = {"/logout"})
    public ModelAndView logout(HttpSession session) {
	session.setAttribute("login_state", false);
	return new ModelAndView("index");
    }
}
