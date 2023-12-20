package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.TicketPaymentData;
import com.stadion.api.mapper.TicketPaymentDataMapper;


@Service
public class TicketPaymentDataService {
	@Autowired
	private TicketPaymentDataMapper ticketPaymentDataMapper;
	
	
	public TicketPaymentData getTicketPaymentData(long accountIdx) {
		if(ticketPaymentDataMapper==null) {return null;}
		
		TicketPaymentData ticketPaymentData = ticketPaymentDataMapper.getTicketPaymentData(accountIdx);
		
		return ticketPaymentData;
	}
	
}
