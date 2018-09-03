
public class Singleton {

	public static Singleton singleton = null;

	// Factory method
	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

	public void show() {

		System.out.println("show");

	}

	public static void main(String... k) {
		Singleton s = Singleton.getInstance();
		System.out.println(s.hashCode());

		Singleton s2 = Singleton.getInstance();
		System.out.println(s2.hashCode());

		Singleton s3 = Singleton.getInstance();
		System.out.println(s3.hashCode());
	}

}
