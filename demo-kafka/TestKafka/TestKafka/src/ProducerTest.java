import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import util.DateUtils;
import util.JsonUtil;
import util.StringUtil;
import vo.TXDataObject;

public class ProducerTest {
	private static CountDownLatch mCountDownLatch = new CountDownLatch(10);
	public static KafkaProducer<String, String> producer = null;
	Properties config = null;

	public static void main(String[] args) {
		
		ProducerTest ps = new ProducerTest();
		ps.process();
	}

	public void process() {
		InputStream is = null;
		try {
			is = ProducerTest.class.getResourceAsStream("application.properties");
			config = new Properties();
			config.load(is);
			System.out.println(getParkOut("mb.park.out").getBytes().length);
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
			if ("true".equals(config.getProperty("send.park.info"))) {
				sendData(config.getProperty("topic_park_info","mb.park.info"), getParkInfo("mb.park.info"), 1);
				System.out.println("----send mb.park.info over  !");
			}
			if ("true".equals(config.getProperty("send.park.ecard"))) {
				new Thread() {

					@Override
					public void run() {
						try {
							for (int i = 0; i < Integer.valueOf(config.getProperty("send.total.count", "")); i++) {
								sendData(config.getProperty("topic_park_ecard","mb.park.ecard"), getParkEcard(), i);
								if ("true".equals(config.getProperty("send.wait", "false"))) {
									Thread.sleep(100);
								}
							}

							System.out.println("----send mb.park.ecard over  !");
						} catch (Exception e) {
							e.printStackTrace();
						}
						mCountDownLatch.countDown();
					}

				}.start();
			}
			if ("true".equals(config.getProperty("send.park.in"))) {
				new Thread() {

					@Override
					public void run() {
						try {
							for (int i = 0; i < Integer.valueOf(config.getProperty("send.total.count", "")); i++) {
								sendData(config.getProperty("topic_park_in","mb.park.in"), getParkIn("mb.park.in"), i + 1);
								if ("true".equals(config.getProperty("send.wait", "false"))) {
									Thread.sleep(100);
								}

							}
							System.out.println("----send mb.park.in over  !");
						} catch (Exception e) {
							e.printStackTrace();
						}
						mCountDownLatch.countDown();
					}

				}.start();
			}
			if ("true".equals(config.getProperty("send.park.out"))) {
				new Thread() {

					@Override
					public void run() {
						try {
							for (int i = 0; i < Integer.valueOf(config.getProperty("send.total.count", "")); i++) {
								sendData(config.getProperty("topic_park_out","mb.park.out"), getParkOut("mb.park.out"), i + 1);
								if ("true".equals(config.getProperty("send.wait", "false"))) {
									Thread.sleep(100);
								}
							}
							System.out.println("----send mb.park.out over  !");
						} catch (Exception e) {
							e.printStackTrace();
						}
						mCountDownLatch.countDown();
					}

				}.start();

			}

			if ("true".equals(config.getProperty("send.park.order"))) {
				new Thread() {

					@Override
					public void run() {
						try {
							for (int i = 0; i < Integer.valueOf(config.getProperty("send.total.count", "")); i++) {
								sendData(config.getProperty("topic_park_order","mb.park.order"), getParkOrder("mb.park.order"), i + 1);
								if ("true".equals(config.getProperty("send.wait", "false"))) {
									Thread.sleep(100);
								}
							}
							System.out.println("----send mb.park.order over  !");
						} catch (Exception e) {
							e.printStackTrace();
						}
						mCountDownLatch.countDown();
					}

				}.start();

			}
			if ("true".equals(config.getProperty("send.equip.info"))) {
				new Thread() {
					
					@Override
					public void run() {
						try {
							for (int i = 0; i < Integer.valueOf(config.getProperty("send.total.count", "")); i++) {
								sendData(config.getProperty("topic_equip_state","mb.equip.info"), getEquipInfo("mb.equip.info"), i + 1);
								if ("true".equals(config.getProperty("send.wait", "false"))) {
									Thread.sleep(100);
								}
							}
							System.out.println("----send mb.equip.info over  !");
						} catch (Exception e) {
							e.printStackTrace();
						}
						mCountDownLatch.countDown();
					}
					
				}.start();
				
			}
			if ("true".equals(config.getProperty("send.equip.state"))) {
				new Thread() {
					
					@Override
					public void run() {
						try {
							for (int i = 0; i < Integer.valueOf(config.getProperty("send.total.count", "")); i++) {
								sendData(config.getProperty("topic_equip_state","mb.equip.state"), getEquipState("mb.equip.state"), i + 1);
								if ("true".equals(config.getProperty("send.wait", "false"))) {
									Thread.sleep(100);
								}
							}
							System.out.println("----send mb.equip.state over  !");
						} catch (Exception e) {
							e.printStackTrace();
						}
						mCountDownLatch.countDown();
					}
					
				}.start();
				
			}
			
			if ("true".equals(config.getProperty("send.door.inout"))) {
				new Thread() {
					
					@Override
					public void run() {
						try {
							for (int i = 0; i < Integer.valueOf(config.getProperty("send.total.count", "")); i++) {
								sendData(config.getProperty("topic_door.inout","mb.door.inout"), getDoorInOut(), i + 1);
								if ("true".equals(config.getProperty("send.wait", "false"))) {
									Thread.sleep(100);
								}
							}
							System.out.println("----send mb.door.inout over  !");
						} catch (Exception e) {
							e.printStackTrace();
						}
						mCountDownLatch.countDown();
					}
					
				}.start();
				
			}
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

	public void sendData(final String topic, String content, int index) throws InterruptedException, ExecutionException {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, content);
		Future<RecordMetadata> future=producer.send(record);
	
		System.out.println(DateUtils.getCurrDateTimeStr() + ",send:" + index + ",topic:" + topic+",partition:" +future.get().partition()+",offset:"+	future.get().offset()+ ",content:" + content);

	}

	public String getParkInfo(String serviceId) {
		TXDataObject txt = new TXDataObject();
		txt.setAttribute("itemId", StringUtil.getUUID());
		if ("true".equals(config.getProperty("parkCodeRandom"))) {
			txt.setAttribute("parkCode",StringUtil.getRandomNum(15));
		}else{
			txt.setAttribute("parkCode", config.getProperty("park.code"));
		}
		
		txt.setAttribute("parkName", "测试");
		txt.setAttribute("totalSpace", "100");
		txt.setAttribute("inSpace", StringUtil.get4RandomNum());
		txt.setAttribute("telephone", "13511111");
		txt.setAttribute("address", "深圳" + StringUtil.get4RandomNum());
		txt.setAttribute("longitude", "10.33665");
		txt.setAttribute("latitude", "10.33665");
		txt.setAttribute("chargeStandard", "1chSDF随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死死死死死死死死死死死死碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d的冯绍峰的士大夫反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复发生的的方式的发送事实上死是的份上士大夫");
		txt.setAttribute("monthChargeStandard", "monSDF随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采随碟附送的方式的发送的方式士大夫士大夫士大夫士大夫随碟附送发生的2342342342342342334234234的是否松岛枫是士大夫士大夫士大夫森达发斯蒂芬  士大夫d大方大方大方的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶随碟附送的方式的发送的方式是的反复反复反复反复反复反复反复反复反复反复反LOB，Large Objects，是一种用于存储大对象的数据类型，一般LOB又分为BLOB与CLOB。BLOB通常用于存储二进制数据，比如图片、音频、视频等。CLOB通常用于存储大文本，比如小说。MySQL数据库中没有专门的CLOB数据类型，而如果要存储大文本，MySQL采");
		System.out.println(txt.getAttribute("chargeStandard").toString().getBytes().length);
		
		txt.setAttribute("status", "NORMAL");
		txt.setAttribute("orderSpace", StringUtil.get4RandomNum());
		txt.setAttribute("bookSpace", StringUtil.get4RandomNum());
		txt.setAttribute("isLock", "1");
		txt.setAttribute("htirdParkCode", "13");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isReal", 1);
		map.put("test", "fff");
		txt.setAttribute("attach", map);
		txt.setAttribute("remark", StringUtil.getUUID());
		String content = JsonUtil.toJson(txt.getAttributes());
		return content;
	}

	public String getParkOrder(String serviceId) {

		Map<String, Object> txt = new HashMap<String, Object>();
		txt.put("itemId", StringUtil.getUUID());
		
		if ("true".equals(config.getProperty("parkCodeRandom"))) {
			txt.put("parkCode",StringUtil.getRandomNum(15));
		}else{
			txt.put("parkCode", config.getProperty("park.code"));
		}
		
		txt.put("parkName", "test");
		txt.put("carNumber", "粤A" + StringUtil.get4RandomNum());
		txt.put("alipayUserId", "test");
		txt.put("alipayParkId", "test222");
		txt.put("businesserCode", "test" + StringUtil.get4RandomNum());
		txt.put("businesserName", "测试" + StringUtil.getRandomNum(8));
		txt.put("orderNo", StringUtil.getUUID());
		txt.put("orderType", "CDP");
		txt.put("channelCode", "test");
		txt.put("transactionId", StringUtil.getUUID());
		txt.put("orderCreateTime", DateUtils.getCurrDateTimeStr());
		txt.put("tradeStatus", "0");
		txt.put("tradeTime", DateUtils.getCurrDateTimeStr());
		txt.put("payType", "2");
		txt.put("totalFee", "100.3");
		txt.put("inTime", DateUtils.getCurrDateTimeStr());
		txt.put("serviceFeeTime", "150");
		txt.put("cardNumber", "ttt");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isReal", 1);
		map.put("test", "fff");
		txt.put("attach", map);
		String content = JsonUtil.toJson(txt);
		return content;
	}

	public String getParkEcard() {

		Map<String, Object> txt = new HashMap<String, Object>();
		txt.put("itemId", StringUtil.getUUID());
		
		if ("true".equals(config.getProperty("parkCodeRandom"))) {
			txt.put("parkCode",StringUtil.getRandomNum(15));
		}else{
			txt.put("parkCode", config.getProperty("park.code"));
		}
		txt.put("parkName", "test");
		txt.put("carNumber", "粤A" + StringUtil.get4RandomNum());
		txt.put("issueTime", DateUtils.getCurrDateTimeStr());
		txt.put("status", "test222");
		txt.put("idno", StringUtil.get4RandomNum());
		txt.put("cardType", "MONTHCARD");
		txt.put("startTime", DateUtils.getCurrDateTimeStr());
		txt.put("endTime", DateUtils.getCurrDateTimeStr());
		txt.put("personId", StringUtil.getUUID());
		txt.put("operateType", "POSTPONED");
		txt.put("operateTime", DateUtils.getCurrDateTimeStr());

		txt.put("operateName", "test");
		txt.put("operateMoney", 100.3);
		txt.put("delayStartTime", DateUtils.getCurrDateTimeStr());
		txt.put("delayEndTime", DateUtils.getCurrDateTimeStr());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isReal", 1);
		map.put("test", "fff");
		txt.put("attach", map);
		String content = JsonUtil.toJson(txt);
		return content;
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public String getParkIn(String serviceId) {
		TXDataObject txt = new TXDataObject();
		txt.setAttribute("itemId",StringUtil.getUUID());
		
		if ("true".equals(config.getProperty("parkCodeRandom"))) {
			txt.setAttribute("parkCode",StringUtil.getRandomNum(15));
		}else{
			txt.setAttribute("parkCode", config.getProperty("park.code"));
		}
		txt.setAttribute("parkName", "测试");
		txt.setAttribute("carNumber", "粤A" + StringUtil.get4RandomNum());
		txt.setAttribute("equipCode", "A000" + StringUtil.get4RandomNum());
		txt.setAttribute("equipName", "设备" + StringUtil.get4RandomNum());
		txt.setAttribute("idno", "A-" + StringUtil.get4RandomNum());
		txt.setAttribute("inOperator", "张山" + StringUtil.getRandomNum(2));
		txt.setAttribute("inTime", DateUtils.getCurrDateTimeStr());
		txt.setAttribute("inCarPhoto", "0000003109/NISSP_IMG_PARK_IN/20171118/66E6318F11C06ACC338B63647FC35111");
		txt.setAttribute("inTotal", StringUtil.getRandomNum(5));
		txt.setAttribute("isReal", 0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isReal", 1);
		map.put("test", "fff");
		txt.setAttribute("attach", map);
		String content = JsonUtil.toJson(txt.getAttributes());
		return content;
	}

	public String getParkOut(String serviceId) {

		TXDataObject txt = new TXDataObject();
		txt.setAttribute("itemId", StringUtil.getUUID());
		txt.setAttribute("inRecordId", StringUtil.getUUID());
		if ("true".equals(config.getProperty("parkCodeRandom"))) {
			txt.setAttribute("parkCode",StringUtil.getRandomNum(15));
		}else{
			txt.setAttribute("parkCode", config.getProperty("park.code"));
		}
		txt.setAttribute("parkName", "测试");
		txt.setAttribute("carNumber", "粤A" + StringUtil.get4RandomNum());
		txt.setAttribute("freeMoney", "10.2");
		txt.setAttribute("hgMoney", "6.2");
		txt.setAttribute("idno", "Ab" + StringUtil.get4RandomNum());
		txt.setAttribute("inEquipCode", "A" + StringUtil.getRandomNum(8));
		txt.setAttribute("inEquipName", "设备" + StringUtil.getRandomNum(8));
		txt.setAttribute("inTime", DateUtils.getCurrDateTimeStr());
		txt.setAttribute("inTotal", StringUtil.getRandomNum(3));
		txt.setAttribute("outEquipCode", "B" + StringUtil.getRandomNum(8));
		txt.setAttribute("outEquipName", "设备" + StringUtil.getRandomNum(8));
		txt.setAttribute("outMode", "3df");
		txt.setAttribute("outOperator", "测试");
		txt.setAttribute("outTime", DateUtils.getCurrDateTimeStr());
		txt.setAttribute("outCarPhoto", "0000003109/NISSP_IMG_PARK_IN/20171118/66E6318F11C06ACC338B63647FC35111");
		txt.setAttribute("payTypeName", "现金");
		txt.setAttribute("ssMoney", "5454.9");
		txt.setAttribute("yhMoney", "545.4");
		txt.setAttribute("ysMoney", "55.2");
		txt.setAttribute("isReal", 0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isReal", 1);
		map.put("test", "fff");
		txt.setAttribute("attach", map);
		String content = JsonUtil.toJson(txt.getAttributes());
		return content;
	}
	

	public String getEquipState(String serviceId) {

		TXDataObject txt = new TXDataObject();
		txt.setAttribute("itemId", "0b93621e74f4412891f950ce98da2194");
		txt.setAttribute("state", "01");
		String content = JsonUtil.toJson(txt.getAttributes());
		return content;
	}
	
	public String getEquipInfo(String serviceId) {

		TXDataObject txt = new TXDataObject();
		txt.setAttribute("itemId", getUUID());
		if ("true".equals(config.getProperty("parkCodeRandom"))) {
			txt.setAttribute("parkCode",StringUtil.getRandomNum(15));
		}else{
			txt.setAttribute("parkCode", config.getProperty("park.code"));
		}
		txt.setAttribute("parkName", "测试22");
		txt.setAttribute("equipCode", "A22" + StringUtil.getRandomNum(8));
		txt.setAttribute("equipName", "设备22" + StringUtil.getRandomNum(8));
		txt.setAttribute("equipType", "0201");
		txt.setAttribute("status", "NORMAL");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isReal", 1);
		map.put("test", "fff");
		txt.setAttribute("attach", map);
		String content = JsonUtil.toJson(txt.getAttributes());
		return content;
	}
	
	public String getDoorInOut() {

		TXDataObject txt = new TXDataObject();
		txt.setAttribute("itemId", getUUID());
		if ("true".equals(config.getProperty("parkCodeRandom"))) {
			txt.setAttribute("parkCode",StringUtil.getRandomNum(15));
		}else{
			txt.setAttribute("parkCode", config.getProperty("park.code"));
		}
		txt.setAttribute("parkName", "测试22");
		txt.setAttribute("equipCode", "A22" + StringUtil.getRandomNum(8));
		txt.setAttribute("equipName", "设备22" + StringUtil.getRandomNum(8));
		txt.setAttribute("equipType", "0201");
		txt.setAttribute("openType", "BRUSHCARD");
		txt.setAttribute("openTime",DateUtils.getCurrDateTimeStr());
		txt.setAttribute("idno", StringUtil.getRandomNum(8));
		txt.setAttribute("cardType", StringUtil.getRandomNum(8));
		txt.setAttribute("mediaType","ID");
		txt.setAttribute("recordType", 0);
		txt.setAttribute("ownerName", StringUtil.getRandomNum(8));
		txt.setAttribute("ownerPhone", StringUtil.getRandomNum(8));
		txt.setAttribute("visitorName", StringUtil.getRandomNum(8));
		txt.setAttribute("visitorPhone", StringUtil.getRandomNum(8));
		String content = JsonUtil.toJson(txt.getAttributes());
		return content;
	}
}
