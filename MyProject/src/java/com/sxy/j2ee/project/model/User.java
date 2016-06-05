/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.model;

import java.sql.Timestamp;

/**
 *
 * @author Y400
 */
public class User {

    private String name;
    private String pwMd5;
    private String email;
    private int age;
    private String gender;
    private Timestamp regDate;
    private String summary;
    private long pNum;
    private String password;
    private String password_re;
    private String age_string;
    private String pNum_string;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getGender() {
	return gender;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public String getSummary() {
	return summary;
    }

    public void setSummary(String summary) {
	this.summary = summary;
    }

    public String getPwMd5() {
	return pwMd5;
    }

    public void setPwMd5(String pwMd5) {
	this.pwMd5 = pwMd5;
    }

    public Timestamp getRegDate() {
	return regDate;
    }

    public void setRegDate(Timestamp regDate) {
	this.regDate = regDate;
    }

    public long getpNum() {
	return pNum;
    }

    public void setpNum(long pNum) {
	this.pNum = pNum;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getPassword_re() {
	return password_re;
    }

    public void setPassword_re(String password_re) {
	this.password_re = password_re;
    }

    public String getAge_string() {
	return age_string;
    }

    public void setAge_string(String age_string) {
	this.age_string = age_string;
    }

    public String getpNum_string() {
	return pNum_string;
    }

    public void setpNum_string(String pNum_string) {
	this.pNum_string = pNum_string;
    }
}
