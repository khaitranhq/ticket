package com.crossaz.booker.rpc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
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

		serviceConfig.setApplication(applicationConfig);
		serviceConfig.setRegistry(registryConfig);
		serviceConfig.setProtocol(protocolConfig);
		serviceConfig.setInterface(ITicketService.class);
		serviceConfig.setRef(ticketServiceRmi);

		System.out.println("1");
		serviceConfig.export();
		System.out.println("2");
	}
}
