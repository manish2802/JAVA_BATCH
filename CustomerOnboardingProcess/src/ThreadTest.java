class ThreadTest implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String args[]) {
		System.out.println(Thread.currentThread().getName());
		ThreadTest m1 = new ThreadTest();
		Thread t1 = new Thread(m1);
		t1.start();

		ThreadTest m2 = new ThreadTest();
		Thread t2 = new Thread(m2);
		t2.start();
	}
}