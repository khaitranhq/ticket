package com.crossaz.api.rpc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.crossaz.api.rmi.ITicketServiceRmi;
import com.crossaz.api.rmi.impl.TicketServiceRmiImpl;

@Component
public class DubboInitializor {
	@Autowired
	ApplicationConfig applicationConfig;
	
	@Autowired
	RegistryConfig registryConfig;
	
	@Autowired
	ProtocolConfig protocolConfig;
	
	ServiceConfig<ITicketServiceRmi> serviceConfig;
	
	@PostConstruct
	public void init() {
		System.out.println("Okkkkk");
		ITicketServiceRmi ticketServiceRmi = new TicketServiceRmiImpl();
	
		serviceConfig = new ServiceConfig<ITicketServiceRmi>();
		
		serviceConfig.setApplication(applicationConfig);
		serviceConfig.setRegistry(registryConfig);
		serviceConfig.setProtocol(protocolConfig);
		serviceConfig.setInterface(ITicketServiceRmi.class);
		serviceConfig.setRef(ticketServiceRmi);
		
		serviceConfig.setVersion("1.0.0");

		serviceConfig.export();
	}
}
