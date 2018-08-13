package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newgen.dao.CreateCustomerDAOImpl;
import com.newgen.dto.CustomerDTO;

public class GetAllCustomerController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GetAllCustomerController() {
		System.out.println("GetAllCustomerController");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws  ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		try {
			List<CustomerDTO> list = CreateCustomerDAOImpl.getInstance().getCustomer();
		

			//pw.print("<body>");
			//pw.print("<div class=\"container\">");

			pw.print("<table class=\"table\">");
			pw.print(
					" <thead><tr><th>First Name</th><th>Last Name</th><th>Dob</th><th>Mobile Number</th><th>Gender</th><th>State</th><th>City</th></tr>  </thead>");
			for (CustomerDTO ct : list) {

				pw.print("<tr>");
				pw.print("<td>" + ct.getFirstName() + "</td>");
				pw.print("<td>" + ct.getLastName() + "</td>");
				pw.print("<td>" + ct.getDob() + "</td>");
				pw.print("<td>" + ct.getMobileNum() + "</td>");
				pw.print("<td>" + ct.getGender() + "</td>");
				pw.print("<td>" + ct.getState() + "</td>");
				pw.print("<td>" + ct.getCity() + "</td>");

				pw.print("</tr>");

			}
			pw.print("</table>");
			//pw.print("</body>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
