package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns="/customer")
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeController() {
		System.out.println("HomeController");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");// setting the content type
		res.setHeader("login", "as");
		PrintWriter pw = res.getWriter();// get the stream to write the data
		RequestDispatcher rd1 = req.getRequestDispatcher("/home.html");

		rd1.include(req, res);
		
		pw.close();// closing the stream

	}

}
