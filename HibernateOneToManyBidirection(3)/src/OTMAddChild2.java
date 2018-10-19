
import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.entity.CustomerDTO;
import com.asthvinayak.entity.ItemDTO;

public class OTMAddChild2 {

	public static void main(String[] args) {

		// Child-new
		ItemDTO item3 = new ItemDTO();
		item3.setItemId("600");
		item3.setItemName("dove");
		item3.setPrice(300);

		CustomerDTO cust = (CustomerDTO) OTMDaoFactory.getInstance().addNewchild("103",item3);
		System.out.println(cust.toString());
	}
}
