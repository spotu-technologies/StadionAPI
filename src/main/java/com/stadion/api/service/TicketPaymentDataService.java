package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.TicketPaymentData;
import com.stadion.api.mapper.TicketPaymentDataMapper;


@Service
public class TicketPaymentDataService {
	@Autowired
	private TicketPaymentDataMapper ticketPaymentDataMapper;
	
	public List<TicketPaymentData> getTicketPaymentDataBox(long accountIdx) {
		if(ticketPaymentDataMapper==null) {return null;}
		
		List<TicketPaymentData> ticketPaymentDataList = ticketPaymentDataMapper.getTicketPaymentDataBox(accountIdx);
		
		return ticketPaymentDataList;
	}
	
	
	public TicketPaymentData getTicketPaymentData(long accountIdx) {
		if(ticketPaymentDataMapper==null) {return null;}
		
		TicketPaymentData ticketPaymentData = ticketPaymentDataMapper.getTicketPaymentData(accountIdx);
		
		return ticketPaymentData;
	}
	
}
