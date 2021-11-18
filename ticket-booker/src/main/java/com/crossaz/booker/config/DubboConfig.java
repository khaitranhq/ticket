package com.crossaz.booker.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
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
	ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName("dubbo");
		protocolConfig.setPort(port);
		protocolConfig.setDispatcher("execution");
		protocolConfig.setThreadpool("cached");
		
		return protocolConfig;
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