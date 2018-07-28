package com.newgen.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newgen.constant.QueryConstant;
import com.newgen.dto.CustomerDTO;
import com.newgen.util.DBUtil;

public class CreateCustomerDAOImpl {

	private CreateCustomerDAOImpl() {

	}

	static CreateCustomerDAOImpl INSTANCE = null;

	public static synchronized CreateCustomerDAOImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CreateCustomerDAOImpl();
			return INSTANCE;
		}
		return INSTANCE;
	}

	/**
	 * For creation of data of new customer.
	 *
	 * @param cusomerDTO
	 * @throws SQLException
	 */
	public void creatCustomer(CustomerDTO cusomerDTO) throws SQLException {
		System.out.println("Enter into creatCustomer ");
		Connection con = DBUtil.getConnection();
		PreparedStatement pstm = con.prepareStatement(QueryConstant.CREATE_CUST);

		pstm.setString(1, cusomerDTO.getFirstName());
		pstm.setString(2, cusomerDTO.getLastName());
		pstm.setString(3, cusomerDTO.getDob() + "");
		pstm.setString(4, cusomerDTO.getGender());
		pstm.setString(5, cusomerDTO.getMobileNum());
		pstm.setString(6, cusomerDTO.getAddress());
		pstm.setString(7, cusomerDTO.getPanNo());
		pstm.setString(8, cusomerDTO.getState());
		pstm.setString(9, cusomerDTO.getCity());
		pstm.setString(10, cusomerDTO.getZipCode());
		int i = pstm.executeUpdate();

		System.out.println(i + "Record inserted successfully");
		DBUtil.closeConnection(con, pstm);

	}

	/**
	 * Getting All customer detials.
	 * 
	 * @param cusomerDTO
	 * @throws SQLException
	 */
	public List<CustomerDTO> getCustomer() throws SQLException {
		System.out.println("Enter into getCustomer ");

		List<CustomerDTO> listCustomers = new ArrayList<CustomerDTO>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstm = con.prepareStatement(QueryConstant.GET_ALL_CUST);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String fName = rs.getString("FIRST_NAME");
			String lName = rs.getString("LAST_NAME");
			Date dob = rs.getDate("DOB");
			String gender = rs.getString("GENDER");
			String mobileNum = rs.getString("MOBILE_NUM");
			String address = rs.getString("ADDRESS");
			String panNo = rs.getString("PAN_NO");
			String state = rs.getString("STATE");
			String city = rs.getString("CITY");
			String zip = rs.getString("ZIP");

			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setFirstName(fName);
			customerDTO.setLastName(lName);
			customerDTO.setDob(dob);
			customerDTO.setGender(gender);
			customerDTO.setMobileNum(mobileNum);
			customerDTO.setAddress(address);
			customerDTO.setPanNo(panNo);
			customerDTO.setCity(city);
			customerDTO.setState(state);
			listCustomers.add(customerDTO);
		}

		DBUtil.closeConnection(con, pstm);
		return listCustomers;

	}

	public static void updateCustomer() throws SQLException {
		System.out.println("Enter into creatCustomer ");
		Connection con = DBUtil.getConnection();

	}

	public static void main(String... k) throws SQLException {
		CreateCustomerDAOImpl.getInstance().getCustomer();
	}

}
