package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginController() {
		System.out.println("LoginController");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");// setting the content type
		PrintWriter pw = res.getWriter();// get the stream to write the data

		String userName = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");
		System.out.println(userName + " " + password);

		if ("manish".equals(userName) && "1234".equals(password)) {
			HttpSession session = req.getSession(true);
			session.setMaxInactiveInterval(1 * 60);
			session.setAttribute("USER", "Manish");
			res.sendRedirect("header");
		} else {

			System.out.println(req.getRequestURI());
			res.sendRedirect(req.getContextPath() + "/login.html");

		}
		pw.close();// closing the stream

	}

}
