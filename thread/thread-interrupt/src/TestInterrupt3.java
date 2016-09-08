
/**
 * 对TestInterrupt2的改进
 * @author angelo
 *
 */
public class TestInterrupt3 {
	
	public static void main(String[] args) {
		TestInterrupt3 test = new TestInterrupt3();
	    MyThread thread = test.new MyThread();  
	    thread.start();
	    try {
	        Thread.currentThread().sleep(2000);
	    } catch (InterruptedException e) {

	    }
	    /**
	     * 但是如果配合isInterrupted()能够中断正在运行的线程，因为调用interrupt方法相当于将中断标志位置为true，
	     * 那么可以通过调用isInterrupted()判断中断标志是否被置位来中断线程的执行
	     * 
	     * 但是一般情况下不建议通过这种方式来中断线程，一般会在MyThread类中增加一个属性 isStop来标志是否结束while循环，
	     * 然后再在while循环中判断isStop的值。
	     */
	    thread.interrupt();
	}
	
	class MyThread extends Thread{
		
		private volatile boolean isStop = false;
		
		@Override
		public void run(){
			int i = 0;

			//第一种方式
//            while(i<Integer.MAX_VALUE && !Thread.currentThread().isInterrupted()){
//
//                System.out.println(i+" while循环");
//
//                i++;
//
//            }
			//第二种方式
            
            while(!isStop){

                System.out.println(i+" while循环");

                i++;

            }
		}
		
		public void setStop(boolean stop){

            this.isStop = stop;

        }
	}

}
