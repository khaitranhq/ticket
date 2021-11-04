package com.crossaz.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crossaz.common.rmi.ITicketService;

@RestController
public class TicketController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketController.class);
	
	@Reference(check=false)
	private ITicketService iTicketService;
	
	@RequestMapping(value="/ticket", method=RequestMethod.POST)
	public int createTicketOrder() {
		System.out.println(iTicketService);
		return iTicketService.getTicketPrice(2);
	}
}
