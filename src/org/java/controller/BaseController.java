package org.java.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController{
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpSession session;
}
