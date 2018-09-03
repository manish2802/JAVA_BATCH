package com.newgen.dao;

import java.sql.SQLException;

import com.newgen.dto.CustomerDTO;

public interface CreateCustomerDAO {

	public void creatCustomer(CustomerDTO cusomerDTO) throws SQLException;

}
