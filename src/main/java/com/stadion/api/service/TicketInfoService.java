package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.TicketInfo;
import com.stadion.api.mapper.TicketInfoMapper;


@Service
public class TicketInfoService {
	@Autowired
	private TicketInfoMapper ticketInfoMapper;
	
	
	public TicketInfo getTicketInfo(String userId) {
		if(ticketInfoMapper==null) {return null;}
		
		TicketInfo ticketInfo = ticketInfoMapper.getTicketInfo(userId);
		
		return ticketInfo;
	}
	public TicketInfo getTicketInfoByEmail(String emailAddress) {
		if(ticketInfoMapper==null) {return null;}
		
		TicketInfo ticketInfo = ticketInfoMapper.getTicketInfoByEmail(emailAddress);
		
		return ticketInfo;
	}

}
