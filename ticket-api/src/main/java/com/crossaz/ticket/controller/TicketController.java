package com.crossaz.ticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketController.class);
	
	@RequestMapping(value="/ticket", method=RequestMethod.POST)
	public String createTicketOrder() {
		return "Ok";
	}
}
