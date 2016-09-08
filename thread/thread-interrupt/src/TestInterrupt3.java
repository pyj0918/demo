
/**
 * ��TestInterrupt2�ĸĽ�
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
	     * ����������isInterrupted()�ܹ��ж��������е��̣߳���Ϊ����interrupt�����൱�ڽ��жϱ�־λ��Ϊtrue��
	     * ��ô����ͨ������isInterrupted()�ж��жϱ�־�Ƿ���λ���ж��̵߳�ִ��
	     * 
	     * ����һ������²�����ͨ�����ַ�ʽ���ж��̣߳�һ�����MyThread��������һ������ isStop����־�Ƿ����whileѭ����
	     * Ȼ������whileѭ�����ж�isStop��ֵ��
	     */
	    thread.interrupt();
	}
	
	class MyThread extends Thread{
		
		private volatile boolean isStop = false;
		
		@Override
		public void run(){
			int i = 0;

			//��һ�ַ�ʽ
//            while(i<Integer.MAX_VALUE && !Thread.currentThread().isInterrupted()){
//
//                System.out.println(i+" whileѭ��");
//
//                i++;
//
//            }
			//�ڶ��ַ�ʽ
            
            while(!isStop){

                System.out.println(i+" whileѭ��");

                i++;

            }
		}
		
		public void setStop(boolean stop){

            this.isStop = stop;

        }
	}

}
