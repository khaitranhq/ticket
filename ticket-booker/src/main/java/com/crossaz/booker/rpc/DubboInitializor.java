package com.crossaz.booker.rpc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import com.crossaz.common.rmi.ITicketService;
import com.crossaz.booker.service.impl.TicketServiceImpl;

@Component
public class DubboInitializor {
	@Autowired
	ApplicationConfig applicationConfig;

	@Autowired
	RegistryConfig registryConfig;

	@Autowired
	ProtocolConfig protocolConfig;

	ServiceConfig<ITicketService> serviceConfig = new ServiceConfig<ITicketService>();

	@PostConstruct
	public void init() {
		ITicketService ticketServiceRmi = new TicketServiceImpl();

		System.out.println(applicationConfig.getName());
		serviceConfig.setApplication(applicationConfig);
		serviceConfig.setRegistry(registryConfig);
		serviceConfig.setProtocol(protocolConfig);
		serviceConfig.setInterface(ITicketService.class);
		serviceConfig.setRef(ticketServiceRmi);

		serviceConfig.export();
	}
}
