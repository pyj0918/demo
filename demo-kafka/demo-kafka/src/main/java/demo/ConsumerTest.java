package demo;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

public class ConsumerTest extends Thread {
	String servers;

	public static void main(String[] args) {
		try {
			new ConsumerTest("10.101.95.21:9092").start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ConsumerTest(String servers) {
		this.servers = servers;
	}

	@Override
	public void run() {
		read();
	}

	public void read() {
		System.out.println("**************读取信息");
		Properties props = new Properties();
		props.put("bootstrap.servers", servers);
		props.put("group.id", "manualOffsetControlTest2");
		props.put("max.poll.records", "500");
		props.put("max.poll.interval.ms", "60000");

		props.put("auto.commit.interval.ms", 99999999);
		// This is how to control number of messages being read in each poll
		props.put("max.partition.fetch.bytes", "135");
		props.put("heartbeat.interval.ms", "3000");
		props.put("session.timeout.ms", "6001");
		props.put("group.id", "myGroup");
		props.put("auto.offset.reset", "latest");

		// 手动提交
		props.put("enable.auto.commit", "false");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("shuaige"), new ConsumerRebalanceListener() {
			@Override
			public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
				for (TopicPartition partition : partitions) {
					System.out.println("----onPartitionsRevoked: partition:" + partition.partition() + ",offset:" + consumer.position(partition) + ":::::" + partition);
				}

			}

			@Override
			public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
				for (TopicPartition partition : partitions) {
					consumer.seek(partition, 80);
					System.out.println("----onPartitionsAssigned: partition:" + partition.partition() + ",offset:" + consumer.position(partition) + ":::::" + partition);
				}

			}
		});
		// 每次处理200条消息后才提交
		//final int minBatchSize = 10;
		// 用于保存消息的list
		//ArrayList<ConsumerRecord<String, String>> buffer = new ArrayList<>();
		try {
			// while (true) {
			// ConsumerRecords<String, String> records = consumer.poll(100000);
			// for (ConsumerRecord<String, String> record : records) {
			// buffer.add(record);
			// System.out.println(record);
			// }
			// // 如果读取到的消息满了200条, 就进行处理
			// if (buffer.size() >= minBatchSize) {
			// // 处理完之后进行提交
			// consumer.commitAsync();
			// // 清除list, 继续接收
			// buffer.clear();
			// }
			// }
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(60000);
				for (TopicPartition partition : records.partitions()) {
					List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
					for (ConsumerRecord<String, String> record : partitionRecords) {
						System.out.println("-----read:partition:" + partition.partition() + ",offset:" + record.offset() + ": " + record.value());
					}
					long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
					//consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)));
				}
			}
		} finally {
			consumer.close();
		}
	}
}
