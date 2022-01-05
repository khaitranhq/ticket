package com.crossaz.ticket.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MQConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.crossaz.ticket.config.RocketMQConfig;

@Component
public class RocketMQProducer {
	@Autowired
	RocketMQConfig rocketMQConfig;
	
	@Bean
	MQConsumer defaultProducer() {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group_name");
		consumer.setNamesrvAddr(rocketMQConfig.getNamesrvAddr());
		return consumer;
	}
}