import java.sql.Date;
import java.sql.SQLException;

import com.newgen.dao.CreateCustomerDAOImpl;
import com.newgen.dto.CustomerDTO;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		CustomerDTO cusomerDTO = new CustomerDTO();
		cusomerDTO.setFirstName("suszvzvhil");
		cusomerDTO.setLastName("gupta");
		cusomerDTO.setDob(new Date(0));
		cusomerDTO.setGender("M");
		cusomerDTO.setAddress("Shanghvi");
		cusomerDTO.setCity("pune");
		cusomerDTO.setMobileNum("7898063452");
		cusomerDTO.setPanNo("BOU88889Z");
		cusomerDTO.setState("MP");
		cusomerDTO.setZipCode("5699001");

		CustomerDTO cusomerDTO2 = new CustomerDTO();
		cusomerDTO2.setFirstName("aszvzvishs");
		cusomerDTO2.setLastName("gupta");
		cusomerDTO2.setDob(new Date(0));
		cusomerDTO2.setGender("M");
		cusomerDTO2.setAddress("Shanghvi");
		cusomerDTO2.setCity("pune");
		cusomerDTO2.setMobileNum("7898063452");
		cusomerDTO2.setPanNo("BOU88889Z");
		cusomerDTO2.setState("MP");
		cusomerDTO2.setZipCode("90909");

		CreateCustomerDAOImpl c = CreateCustomerDAOImpl.getInstance();
		CreateCustomerDAOImpl c1 = CreateCustomerDAOImpl.getInstance();
		c.creatCustomer(cusomerDTO);
		c.creatCustomer(cusomerDTO2);
		
		

	}

}
