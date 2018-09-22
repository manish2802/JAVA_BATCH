import com.service.ws.WheatherService;
import com.service.ws.WheatherServiceImplService;

public class Client {

	public static void main(String str) {
		// TODO Auto-generated method stub

		WheatherServiceImplService ws = new WheatherServiceImplService();
		WheatherService we = ws.getPort(WheatherService.class);
		String wh = we.getWheather(str);
		System.out.println(wh);

	}

}
