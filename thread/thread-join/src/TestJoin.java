public class TestJoin {
	public static void main(String[] args) {
		final Thread thread1 = new Thread() {
			public void run() {
				System.out.println("���ǵ�һ��");
				try {
					Thread.sleep(30000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("��Ȼ˯��һ��,�����ǵڶ���");
			}
		};

		thread1.start();

		Thread thread2 = new Thread() {

			public void run() {
				try {
					System.out.println("��t1���");
					// �ȴ�t1�߳� ִ����ᣬ�ż�������ִ�� �����������߳�
					thread1.join();
				} catch (Exception e) {

				}
				System.out.println("���ǵ�����");
			}
		};
		
		thread2.start();
		
		try {
			System.out.println("���̱߳�������");
			// �����������߳�
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("���̻߳���");
	}

}
