package com.crossaz.booker.service.impl;

import org.apache.dubbo.config.annotation.DubboService;

import com.crossaz.common.rmi.ITicketService;

@DubboService
public class TicketServiceImpl implements ITicketService {

	@Override
	public int getTicketPrice(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}