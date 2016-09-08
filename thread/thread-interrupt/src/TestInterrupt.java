
/**
 * �жϴ�������״̬���߳�
 * @author angelo
 *
 */
public class TestInterrupt {
	
	/**
	 * interrupt������˼�壬���жϵ���˼����������interrupt��������ʹ�ô�������״̬���߳��׳�һ���쳣��Ҳ��˵��
	 * �����������ж�һ������������״̬���̣߳����⣬ͨ��interrupt������isInterrupted()������ֹͣ�������е��̡߳�
	 * 
	 */
	
	
	public static void main(String[] args) {
		TestInterrupt test = new TestInterrupt();
		MyThread thread = test.new MyThread();
		thread.start();
		try {
			Thread.currentThread().sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		thread.interrupt();
	}
	
	
	class MyThread extends Thread{
		@Override
		public void run(){
			try {

                System.out.println("����˯��״̬");

                Thread.currentThread().sleep(10000);

                System.out.println("˯�����");

            } catch (InterruptedException e) {
            	e.printStackTrace();
                System.out.println("�õ��ж��쳣");

            }

            System.out.println("run����ִ�����");
		}
	}

}
