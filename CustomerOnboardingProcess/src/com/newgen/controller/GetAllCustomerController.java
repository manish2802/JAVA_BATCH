package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newgen.dao.CreateCustomerDAOImpl;
import com.newgen.dto.CustomerDTO;

//@WebServlet(urlPatterns = "/all-customer")
public class GetAllCustomerController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GetAllCustomerController() {
		System.out.println("Object has been created ");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		try { 
			List<CustomerDTO> list = CreateCustomerDAOImpl.getInstance().getCustomer();

			pw.println("<body>");
			pw.println(" <thead><tr><th>First Name</th><th>Last Name</th><th>Dob</th></tr>  </thead>");
			pw.println("<table>");
			for (CustomerDTO ct : list) {

				pw.println("<tr>");
				pw.println("<th>" + ct.getFirstName() + "</th>");
				pw.println("<th>" + ct.getLastName() + "</th>");
				pw.println("<th>" + ct.getDob() + "</th>");
				pw.println("</tr>");

			}
			pw.println("</table>");
			pw.println("</body>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pw.close();// closing the stream

	}

}
