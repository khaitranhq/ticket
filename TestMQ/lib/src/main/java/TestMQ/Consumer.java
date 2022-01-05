package TestMQ;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

public class Consumer {

	public static void main(String[] args) throws InterruptedException, MQClientException {

		// Instantiate the consumer
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("A");

		// Set the address
		consumer.setNamesrvAddr("54.255.193.212:9876");

		// Subscribe to one or more Topic, and Tag to filter the message
		consumer.subscribe("TopicTest", "*");
		// Register the callback implementation class to process the message pulled back
		// from the broker
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				System.out.printf(" %s Receive New Messages: %s %n ", Thread.currentThread().getName(), msgs);
				// Mark the message has been successfully consumed
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		// Start the consumer instance
		consumer.start();
		System.out.printf(" Consumer Started.%n ");
	}
}
