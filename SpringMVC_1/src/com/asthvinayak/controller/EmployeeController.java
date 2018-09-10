package com.asthvinayak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asthvinayak.business.EmployeeBO;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeBO employeeBO;

	@RequestMapping("/employee")
	public ModelAndView getEmployee() {
		ModelAndView mav = new ModelAndView("employee", "key", employeeBO.getEmployeeDetail());
		return mav;
	}

}
