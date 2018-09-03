package com.newgen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/*")
public class LoginFilter implements Filter {

	public LoginFilter() {
		System.out.println("LoginFilter");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// If you have any <init-param> in web.xml, then you could get them
		// here by config.getInitParameter("name") and assign it as field.
		// System.out.println("Login Filter");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		HttpSession session = request.getSession(false);
		String requestPath = request.getRequestURI();
		System.out.println(requestPath);
		if ( requestPath.endsWith("login.html")
				|| (requestPath.contains("login") && request.getMethod().equals("POST"))) {
			chain.doFilter(request, response);
		} else if (null != session) {
			chain.doFilter(request, response);
		} else {
			response.setHeader("status", "session-out");
			response.sendRedirect("login.html");
		}

	}

	@Override
	public void destroy() {
		// If you have assigned any expensive resources as field of
		// this Filter class, then you could clean/close them here.
	}

	// basic validation of pages that do not require authentication
	private boolean needsAuthentication(String url) {
		String[] validNonAuthenticationUrls = { "/customer", "/create", "/home" };
		for (String validUrl : validNonAuthenticationUrls) {
			if (url.endsWith(validUrl)) {
				return false;
			}
		}
		return true;
	}
}