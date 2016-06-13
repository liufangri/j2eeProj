/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.util;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Y400
 */
public class MyModelAndView extends ModelAndView {

    private int numOfObjs = 0;

    public MyModelAndView() {
	super();
    }

    public MyModelAndView(String viewName) {
	super(viewName);
    }

    @Override
    public ModelAndView addObject(String attributeName, Object attributeValue) {
	numOfObjs++;
	return super.addObject(attributeName, attributeValue);
    }

    public int getNumOfObjs() {
	return numOfObjs;
    }
}
