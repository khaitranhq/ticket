package TestMQ;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class SyncProducer {
	public static void main(String[] args) {
		try {
			// Instantiate the message producer Producer
			DefaultMQProducer producer = new DefaultMQProducer("A");
			// Set the address of the NameServer
			producer.setNamesrvAddr("54.255.193.212:9876");
//			producer.setSendMsgTimeout(600000);			
			// Start producer instance
			producer.start();
			for (int i = 0; i < 100; i++) {
				System.out.println("Ol");
				// Create a message, and specify Topic, Tag and message body
				Message msg = new Message("TopicTest", "TagA",
						("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
				);
				System.out.println("Ol");
				// Send the message to a Broker
				SendResult sendResult = producer.send(msg);
				// Return whether the message was successfully delivered to the
				System.out.printf(" %s%n ", sendResult);
			}
			// If no more messages are sent, close the Producer instance.
			producer.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
