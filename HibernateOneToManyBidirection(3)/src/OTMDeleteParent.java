import com.asthvinayak.dao.OTMDaoFactory;

public class OTMDeleteParent {

	public static void main(String[] args) {
		OTMDaoFactory.getInstance().removeParent("103");
	}

}
