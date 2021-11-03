package com.crossaz.api.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
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
}
