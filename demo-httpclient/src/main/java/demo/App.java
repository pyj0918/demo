package demo;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		for (int i = 0; i < 2200; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					HttpClientUtil2.get("https://www.baidu.com");
					System.out.println(Thread.currentThread().getName());
				}
			});
			thread.start();
		}
		//HttpClientUtil2.get("https://www.baidu.com");
		
	}
}
