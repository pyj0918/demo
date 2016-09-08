public class TestJoin {
	public static void main(String[] args) {
		final Thread thread1 = new Thread() {
			public void run() {
				System.out.println("我是第一个");
				try {
					Thread.sleep(30000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("虽然睡了一会,但我是第二个");
			}
		};

		thread1.start();

		Thread thread2 = new Thread() {

			public void run() {
				try {
					System.out.println("等t1完成");
					// 等待t1线程 执行完结，才继续向下执行 在这阻塞子线程
					thread1.join();
				} catch (Exception e) {

				}
				System.out.println("我是第三个");
			}
		};
		
		thread2.start();
		
		try {
			System.out.println("主线程被阻塞了");
			// 在这阻塞主线程
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("主线程活了");
	}

}
