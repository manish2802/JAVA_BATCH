package com.newgen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogoutController() {
		System.out.println("LogoutController");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");// setting the content type
		
		HttpSession session = req.getSession();
		session.invalidate();
		res.sendRedirect(req.getContextPath() + "/login.html");
		
	}

}
