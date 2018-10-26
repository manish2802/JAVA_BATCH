import java.util.Date;

import com.asthvinayak.dao.OTODaoFactory;
import com.asthvinayak.entity.PassportDTO;
import com.asthvinayak.entity.PersonDTO;

public class OTOAnnotationInsert {

	public static void main(String[] args) {

		PersonDTO person = new PersonDTO();
		person.setPersonId(1101);
		person.setPersonName("Manish");
		person.setGender("M");

		PassportDTO passport = new PassportDTO();
		passport.setPassportId("passport234");
		passport.setIssuedDate(new Date());
		passport.setExpireDate(new Date());
		passport.setPerson(person);

		OTODaoFactory.getInstance().saveOneToOne(passport);

	}
	


}
