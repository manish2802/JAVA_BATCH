package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/header")
public class RootController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RootController() {
		System.out.println("RootController");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");// setting the content type

		HttpSession session = req.getSession(false);
		if (null != session) {
			PrintWriter pw = res.getWriter();// get the stream to write the data
			RequestDispatcher rd = req.getRequestDispatcher("/header.html");
			rd.include(req, res);

			pw.close();// closing the stream
		} else {
			res.setHeader("session", "Expired");
			res.sendRedirect("login.html");
		}

	}

}
