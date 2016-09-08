
/**
 * 中断处于阻塞状态的线程
 * @author angelo
 *
 */
public class TestInterrupt {
	
	/**
	 * interrupt，顾名思义，即中断的意思。单独调用interrupt方法可以使得处于阻塞状态的线程抛出一个异常，也就说，
	 * 它可以用来中断一个正处于阻塞状态的线程；另外，通过interrupt方法和isInterrupted()方法来停止正在运行的线程。
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

                System.out.println("进入睡眠状态");

                Thread.currentThread().sleep(10000);

                System.out.println("睡眠完毕");

            } catch (InterruptedException e) {
            	e.printStackTrace();
                System.out.println("得到中断异常");

            }

            System.out.println("run方法执行完毕");
		}
	}

}
