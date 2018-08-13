package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/welcomeuser")
public class WelcomeUserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WelcomeUserController() {
		System.out.println("WelcomeUserController");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");// setting the content type

		HttpSession session = req.getSession();
		if (null != session) {
			PrintWriter pw = res.getWriter();// get the stream to write the data
			String str = (String) session.getAttribute("USER");
			System.out.println(str);
			pw.println("<div><strong><h3>Welcome: " + str + "</h3></strong></div>");

			pw.close();// closing the stream
		} else {
			//res.setHeader("session", "Expired");
			res.sendRedirect("login.html");
		}

	}

}
