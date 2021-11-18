package com.crossaz.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "dubbo")
public class DubboConfig {
	String zkAddress;
	int port;
	String serverName;
	int timeout;
	String dubboDumpDirectory;

	@Bean
	ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		System.out.println(serverName);
		applicationConfig.setName(serverName);

		return applicationConfig;
	}

	@Bean
	RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();

		registryConfig.setAddress(zkAddress);
		registryConfig.setClient("zkclient");

		return registryConfig;
	}

	@Bean
	public ConsumerConfig consumerConfig() {
		ConsumerConfig consumerConfig = new ConsumerConfig();
		consumerConfig.setTimeout(Integer.valueOf(timeout));
		consumerConfig.setCheck(false);
		consumerConfig.setRetries(0);
		// consumerConfig.setCluster(dubboCluster);
		return consumerConfig;
	}

}
