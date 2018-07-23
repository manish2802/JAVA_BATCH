package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns="/customer")
public class GetCustomerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GetCustomerServlet() {
		System.out.println("Object has been created ");
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");// setting the content type
		PrintWriter pw = res.getWriter();// get the stream to write the data
		RequestDispatcher rd = req.getRequestDispatcher("/header.html");
		RequestDispatcher rd1 = req.getRequestDispatcher("/customerform.html");
		// RequestDispatcher rd = req.getRequestDispatcher("/footer.html");
		rd.include(req, res);
		rd1.include(req, res);

		pw.close();// closing the stream

	}

}
