package com.newgen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newgen.dao.CreateCustomerDAOImpl;
import com.newgen.dto.CusomerDTO;
import com.newgen.util.CommonUtil;

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
		String address = (String) req.getParameter("address");
		String dob = (String) req.getParameter("dob");
		String state = (String) req.getParameter("state");
		String city = (String) req.getParameter("city");
		String panNo = (String) req.getParameter("panno");

		if (CommonUtil.isNotNull(fName) && CommonUtil.isNotNull(lastName) && CommonUtil.isNotNull(address)
				&& CommonUtil.getMobileNoLength(mno) && CommonUtil.isNotNull(state) && CommonUtil.isNotNull(city)
				&& CommonUtil.isNotNull(panNo)) {
			try {
				CusomerDTO cusomerDTO = new CusomerDTO();
				cusomerDTO.setFirstName(fName);
				cusomerDTO.setLastName(lastName);
				cusomerDTO.setDob(new Date(0));
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
				pw.println("<body>" + fName + "</br>" + lastName + "</br>" + gen + "</br>" + dob + "</br>" + address
						+ "</body>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			pw.println("<body>" + "Data missing" + "</body>");
		}

		pw.close();// closing the stream

	}

}
