
/**
 * ������״̬���̣߳��ܷ�ʹ��thread.interrupt()�����жϣ�
 * @author angelo
 *
 */
public class TestInterrupt2 {
	
	public static void main(String[] args) {
		TestInterrupt2 test = new TestInterrupt2();
	    MyThread thread = test.new MyThread();  
	    thread.start();
	    try {
	        Thread.currentThread().sleep(2000);
	    } catch (InterruptedException e) {

	    }
	    //���ڷ�����״̬���̣߳��޷��ж�
	    thread.interrupt();
	}
	
	class MyThread extends Thread{
		@Override
		public void run(){
			int i = 0;

            while(i<Integer.MAX_VALUE){

                System.out.println(i+" whileѭ��");

                i++;

            }
		}
	}

}
