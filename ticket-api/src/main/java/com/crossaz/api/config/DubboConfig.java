package com.crossaz.api.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

	public String getZkAddress() {
		return zkAddress;
	}

	public void setZkAddress(String zkAddress) {
		this.zkAddress = zkAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getDubboDumpDirectory() {
		return dubboDumpDirectory;
	}

	public void setDubboDumpDirectory(String dubboDumpDirectory) {
		this.dubboDumpDirectory = dubboDumpDirectory;
	}
}
