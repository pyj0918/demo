import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import util.DateUtils;
import util.JsonUtil;
import util.StringUtil;

public class ProducerTest2 {
	private static CountDownLatch mCountDownLatch = new CountDownLatch(10);
	public static KafkaProducer<String, String> producer = null;
	Properties config = null;

	public static void main(String[] args) {

		ProducerTest2 ps = new ProducerTest2();
		ps.process();
	}

	public void process() {
		InputStream is = null;
		try {
			is = ProducerTest2.class.getResourceAsStream("application.properties");
			config = new Properties();
			config.load(is);
			// ConsumerTest com = new ConsumerTest(config.getProperty("bootstrap.servers"));
			// com.start();

			Properties props = new Properties();
			props.put("bootstrap.servers", config.getProperty("bootstrap.servers"));
			props.put("retries", 0);
			props.put("linger.ms", 0);
			props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
			props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
			props.put("partitioner.class", "MyPartition");
			producer = new KafkaProducer<String, String>(props);
			sendData("msg.tel", getContent());
			System.out.println("----send   over  !");

			mCountDownLatch.await();

			producer.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (producer != null)
				producer.close();
		}

	}

	public void sendData(final String topic, String content) throws InterruptedException, ExecutionException {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, content);
		Future<RecordMetadata> future = producer.send(record);

		System.out.println(DateUtils.getCurrDateTimeStr() + ",topic:" + topic + ",partition:" + future.get().partition() + ",offset:" + future.get().offset() + ",content:"
				+ content);

	}

	public String getContent() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("itemId", StringUtil.getUUID());
		map.put("pushTime", DateUtils.getCurrDateTimeStr());
		map.put("productCode", "test");
		map.put("mobile", "18682266316");
		map.put("content", "∂Ã–≈∑¢ÀÕ≤‚ ‘");
		String content = JsonUtil.toJson(map);
		return content;
	}

}
