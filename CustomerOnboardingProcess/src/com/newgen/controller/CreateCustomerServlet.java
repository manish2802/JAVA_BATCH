package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns="/customer")
public class CreateCustomerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateCustomerServlet() {
		System.out.println("Object has been created ");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");// setting the content type
		PrintWriter pw = res.getWriter();// get the stream to write the data

		String fName = (String) req.getParameter("fname");
		String lastName = (String) req.getParameter("lname");
		String gen = (String) req.getParameter("gender");
		String mno = (String) req.getParameter("mno");
		pw.println("<body>" + fName + " " + lastName + " " + gen + " " + mno + "</body>");

		pw.close();// closing the stream

	}

}
