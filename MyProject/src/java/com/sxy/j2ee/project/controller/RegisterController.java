/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.controller;

import com.sxy.j2ee.project.model.User;
import com.sxy.j2ee.project.model.UserDaoImpl;
import com.sxy.j2ee.project.security.Md5;
import com.sxy.j2ee.project.util.MyModelAndView;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 对注册相关操作的控制类
 *
 * @author Y400
 */
@Controller
public class RegisterController {

    private UserDaoImpl userDaoImpl;
    private final String[] genders = {"男", "女", "保密"};
    private final String error_name = "error_name";
    private final String error_email = "error_email";
    private final String error_password = "error_password";
    private final String error_password_re = "error_password_re";
    private final String error_pNum = "error_pNum";
    private final String error = "has-error";

    /**
     * 1，输入验证；2，处理注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/registerAction")
    public ModelAndView validation(User user) {
	MyModelAndView mav = new MyModelAndView();
	String name = user.getName();
	if (name == null || name == "") {
	    mav.addObject(error_name, "名称不能为空");
	    mav.addObject("name_has_error", error);
	} else if (name.length() < 3 || name.length() > 10) {
	    mav.addObject(error_name, "名称长度3~10个字符");
	    mav.addObject("name_has_error", error);
	} else if (name.contains("*")) {
	    mav.addObject(error_name, "不能包含非法字符（*...）");
	    mav.addObject("name_has_error", error);
	}

	String password = user.getPassword();
	String password_re = user.getPassword_re();
	if (password == null || password == "") {
	    mav.addObject(error_password, "密码不能为空");
	    mav.addObject("password_has_error", error);
	} else if (password_re == null || password_re == "") {
	    mav.addObject(error_password_re, "确认密码不能为空");
	    mav.addObject("password_re_has_error", error);
	} else if (password.length() < 5 || password.length() > 20) {
	    mav.addObject(error_password, "密码长度为5~20个字符");
	    mav.addObject("password_has_error", error);
	} else if (!password_re.equals(password)) {
	    mav.addObject(error_password_re, "与密码不一致");
	    mav.addObject("password_re_has_error", error);
	}

	String email = user.getEmail();
	if (email == null || email == "") {
	    mav.addObject(error_email, "邮箱不能为空");
	    mav.addObject("email_has_error", error);
	} else if (!email.contains("@") || email.indexOf("@") < 1 || !email.contains(".") || email.indexOf(".") - email.indexOf("@") < 1 || email.length() - email.indexOf(".") < 2) {
	    mav.addObject(error_email, "邮箱格式不正确，请确认后再输入");
	    mav.addObject("email_has_error", error);
	} else if (userDaoImpl.findByEmail(email) != null) {
	    mav.addObject(error_email, "邮箱已被注册");
	    mav.addObject("email_has_error", error);
	}
	String pNum = user.getpNum_string();
	if (pNum == null || pNum == "") {

	} else if (pNum.length() != 11) {
	    mav.addObject(error_pNum, "手机号码长度不对");
	    mav.addObject("pNum_has_error", error);
	} else {
	    user.setpNum(Long.parseLong(pNum));
	}

	if (mav.getNumOfObjs() > 0) {
	    // 输入出错了
	    mav.addObject("has_error", "has-error");
	    mav.addObject("genders", genders);
	    mav.addObject("user", user);
	    mav.setViewName("register");
	    return mav;
	} else {
	    //输入验证通过
	    user.setPwMd5(Md5.Md5_16(password));
	    user.setRegDate(new Timestamp(new Date().getTime()));

	    if (userDaoImpl.insert(user)) {
		mav.addObject("result", user);
		mav.setViewName("test");
		return mav;
	    } else {
		mav.setViewName("error");
		return mav;
	    }

	}
    }

    public UserDaoImpl getUserDaoImpl() {
	return userDaoImpl;
    }

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
	this.userDaoImpl = userDaoImpl;
    }

}
