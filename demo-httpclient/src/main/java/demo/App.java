package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static ThreadLocal<SimpleDateFormat> df = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

	

	}

	public static void get() {
		List<User> l = new ArrayList<User>();

		User u = new User();
		u.setAge("1");
		u.setName("1");

		l.add(u);

		User u2 = new User();
		u2.setAge("1");
		u2.setName("1");

		l.add(u2);

		User u3 = new User();
		u2.setAge("1");
		u2.setName("1");

		if (l.contains(u3)) {
			System.out.println("1");
		} else {
			System.out.println("2");
		}

	}
}
