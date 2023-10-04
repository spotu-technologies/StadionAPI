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
	
	
	public TicketPaymentData getTicketPaymentData(String userId) {
		if(ticketPaymentDataMapper==null) {return null;}
		
		TicketPaymentData ticketPaymentData = ticketPaymentDataMapper.getTicketPaymentData(userId);
		
		return ticketPaymentData;
	}
	public TicketPaymentData getTicketPaymentDataByEmail(String emailAddress) {
		if(ticketPaymentDataMapper==null) {return null;}
		
		TicketPaymentData ticketPaymentData = ticketPaymentDataMapper.getTicketPaymentDataByEmail(emailAddress);
		
		return ticketPaymentData;
	}

}
