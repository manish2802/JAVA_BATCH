package com.newgen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.newgen.constant.QueryConstant;
import com.newgen.dto.CusomerDTO;
import com.newgen.util.DBUtil;

public class CreateCustomerDAOImpl {

	static CreateCustomerDAOImpl INSTANCE = null;

	public static synchronized CreateCustomerDAOImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CreateCustomerDAOImpl();
			return INSTANCE;
		}
		return INSTANCE;
	}

	/**For creation of data of new customer.
	 *
	 * @param cusomerDTO
	 * @throws SQLException
	 */
	public void creatCustomer(CusomerDTO cusomerDTO) throws SQLException {
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

	public void getCustomer(CusomerDTO cusomerDTO) throws SQLException {
		System.out.println("Enter into creatCustomer ");
		Connection con = DBUtil.getConnection();
		PreparedStatement pstm = con.prepareStatement(QueryConstant.CREATE_CUST);

	}

	public void updateCustomer(CusomerDTO cusomerDTO) throws SQLException {
		System.out.println("Enter into creatCustomer ");
		Connection con = DBUtil.getConnection();
		PreparedStatement pstm = con.prepareStatement(QueryConstant.CREATE_CUST);

	}

}
