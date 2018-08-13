package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchController() {
		System.out.println("SearchController");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		RequestDispatcher rd = req.getRequestDispatcher("/header.html");
		rd.include(req, res);

		RequestDispatcher rd3 = req.getRequestDispatcher("/search.html");
		rd3.include(req, res);

		pw.close();// closing the stream

	}

	public static String getBaseUrl(HttpServletRequest request) {
		String scheme = request.getScheme() + "://";
		String serverName = request.getServerName();
		String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
		String contextPath = request.getContextPath();
		return scheme + serverName + serverPort + contextPath;
	}

}
