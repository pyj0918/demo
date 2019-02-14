package demo;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Future;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.pool.BasicConnFactory;
import org.apache.http.impl.pool.BasicConnPool;
import org.apache.http.impl.pool.BasicPoolEntry;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpProcessorBuilder;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.RequestConnControl;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestExpectContinue;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.EntityUtils;

/**
 * 基于httpcore组件的测试
 *
 */
public class HttpCoreTest {

	public static void main(String[] args) throws Exception {
		httpGetWithConnectioPpooling();
	}

	//Synchronous HTTP GET requests
	public static void httpGetTest() throws Exception {
		HttpProcessor httpproc = HttpProcessorBuilder.create()//
				.add(new RequestContent())//
				.add(new RequestTargetHost()) //
				.add(new RequestConnControl())//
				.add(new RequestUserAgent("Test/1.1"))//
				.add(new RequestExpectContinue(true)).build();
		HttpRequestExecutor httpexecutor = new HttpRequestExecutor();
		HttpCoreContext coreContext = HttpCoreContext.create();
		HttpHost host = new HttpHost("localhost", 8080);
		coreContext.setTargetHost(host);
		DefaultBHttpClientConnection conn = new DefaultBHttpClientConnection(8 * 1024);
		ConnectionReuseStrategy connStrategy = DefaultConnectionReuseStrategy.INSTANCE;
		try {
			String[] targets = { "/", "/servlets-examples/servlet/RequestInfoExample", "/somewhere%20in%20pampa" };
			for (int i = 0; i < targets.length; i++) {
				if (!conn.isOpen()) {
					Socket socket = new Socket(host.getHostName(), host.getPort());
					conn.bind(socket);
				}
				BasicHttpRequest request = new BasicHttpRequest("GET", targets[i]);
				System.out.println(">> Request URI: " + request.getRequestLine().getUri());
				httpexecutor.preProcess(request, httpproc, coreContext);
				HttpResponse response = httpexecutor.execute(request, conn, coreContext);
				httpexecutor.postProcess(response, httpproc, coreContext);

				System.out.println("<< Response: " + response.getStatusLine());
				System.out.println(EntityUtils.toString(response.getEntity()));
				System.out.println("==============");
				if (!connStrategy.keepAlive(response, coreContext)) {
					conn.close();
				} else {
					System.out.println("Connection kept alive...");
				}
			}
		} finally {
			conn.close();
		}
	}

	//Synchronous HTTP GET requests with connection pooling
	public static void httpGetWithConnectioPpooling() throws Exception {
		final HttpProcessor httpproc = HttpProcessorBuilder.create()//
				.add(new RequestContent())//
				.add(new RequestTargetHost())//
				.add(new RequestConnControl())//
				.add(new RequestUserAgent("Test/1.1"))//
				.add(new RequestExpectContinue(true))//
				.build();
		final HttpRequestExecutor httpexecutor = new HttpRequestExecutor();
		final BasicConnPool pool = new BasicConnPool(new BasicConnFactory());
		pool.setDefaultMaxPerRoute(2);
		pool.setMaxTotal(2);

		HttpHost[] targets = { new HttpHost("www.baidu.com", 80), new HttpHost("www.hao123.com", 80) };

		class WorkerThread extends Thread {
			private final HttpHost target;

			WorkerThread(final HttpHost target) {
				super();
				this.target = target;
			}

			@Override
			public void run() {
				ConnectionReuseStrategy connStrategy = DefaultConnectionReuseStrategy.INSTANCE;
				try {
					Future<BasicPoolEntry> future = pool.lease(this.target, null);
					boolean reusable = false;
					BasicPoolEntry entry = future.get();
					try {
						HttpClientConnection conn = entry.getConnection();
						HttpCoreContext coreContext = HttpCoreContext.create();
						coreContext.setTargetHost(this.target);

						BasicHttpRequest request = new BasicHttpRequest("GET", "/");
						System.out.println(">> Request URI: " + request.getRequestLine().getUri());

						httpexecutor.preProcess(request, httpproc, coreContext);
						HttpResponse response = httpexecutor.execute(request, conn, coreContext);
						httpexecutor.postProcess(response, httpproc, coreContext);

						System.out.println("<< Response: " + response.getStatusLine());
						System.out.println(EntityUtils.toString(response.getEntity()));

						reusable = connStrategy.keepAlive(response, coreContext);
					} catch (IOException ex) {
						throw ex;
					} catch (HttpException ex) {
						throw ex;
					} finally {
						if (reusable) {
							System.out.println("Connection kept alive...");
						}
						pool.release(entry, reusable);
					}
				} catch (Exception ex) {
					System.out.println("Request to " + this.target + " failed: " + ex.getMessage());
				}
			}

		}
		;//

		WorkerThread[] workers = new WorkerThread[targets.length];
		for (int i = 0; i < workers.length; i++) {
			workers[i] = new WorkerThread(targets[i]);
		}
		for (int i = 0; i < workers.length; i++) {
			workers[i].start();
		}
		for (int i = 0; i < workers.length; i++) {
			workers[i].join();
		}
	}
}
