
/**
 * 非阻塞状态的线程，能否使用thread.interrupt()进行中断？
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
	    //处于非阻塞状态的线程，无法中断
	    thread.interrupt();
	}
	
	class MyThread extends Thread{
		@Override
		public void run(){
			int i = 0;

            while(i<Integer.MAX_VALUE){

                System.out.println(i+" while循环");

                i++;

            }
		}
	}

}
