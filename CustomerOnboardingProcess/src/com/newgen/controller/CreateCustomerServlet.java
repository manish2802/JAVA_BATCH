package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newgen.dao.CreateCustomerDAOImpl;
import com.newgen.dto.CustomerDTO;
import com.newgen.util.CommonUtil;

//@WebServlet(urlPatterns="/customer")
public class CreateCustomerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateCustomerServlet() {
		System.out.println("CreateCustomerServlet");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");// setting the content type
		PrintWriter pw = res.getWriter();// get the stream to write the data

		String fName = (String) req.getParameter("fname");
		String lastName = (String) req.getParameter("lname");
		String gen = (String) req.getParameter("gender");
		String mno = (String) req.getParameter("mno");
		String address = (String) req.getParameter("address");
		String dob = (String) req.getParameter("dob");
		String state = (String) req.getParameter("state");
		String city = (String) req.getParameter("city");
		String panNo = (String) req.getParameter("panno");

		if (CommonUtil.isNotNull(fName) && CommonUtil.isNotNull(lastName) && CommonUtil.isNotNull(address)
				&& CommonUtil.getMobileNoLength(mno) && CommonUtil.isNotNull(state) && CommonUtil.isNotNull(city)
				&& CommonUtil.isNotNull(panNo)) {
			try {
				CustomerDTO cusomerDTO = new CustomerDTO();
				cusomerDTO.setFirstName(fName);
				cusomerDTO.setLastName(lastName);
				cusomerDTO.setDob(CommonUtil.convertStringToSQLDate(dob));
				cusomerDTO.setGender(gen);
				cusomerDTO.setAddress(address);
				cusomerDTO.setCity(city);
				cusomerDTO.setMobileNum(mno);
				cusomerDTO.setPanNo(panNo);
				cusomerDTO.setState(state);
				cusomerDTO.setZipCode("5699001");
				// Persistance Layer
				CreateCustomerDAOImpl createCustomerDAOImpl = CreateCustomerDAOImpl.getInstance();
				createCustomerDAOImpl.creatCustomer(cusomerDTO);

				pw.println("<body>" + "<h1>Record Inserted Sucessfully</h1>" + " " + "</body>");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException parse) {
				parse.getMessage();
				pw.println("<body>" + "Invalid" + "</body>");
			}

		} else {
			pw.println("<body>" + "Data missing" + "</body>");
		}

		pw.close();// closing the stream

	}

}
