package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BoxInfo;
import com.stadion.api.entity.TicketInfo;
import com.stadion.api.mapper.TicketInfoMapper;


@Service
public class TicketInfoService {
	@Autowired
	private TicketInfoMapper ticketInfoMapper;
	
	public List<TicketInfo> getTicketInfoAll() {
		if(ticketInfoMapper==null) {return null;}
		
		List<TicketInfo> ticketInfoList = ticketInfoMapper.getTicketInfoAll();
		
		return ticketInfoList;
	}
	
	
	public TicketInfo getTicketInfo(long idx) {
		if(ticketInfoMapper==null) {return null;}
		
		TicketInfo ticketInfo = ticketInfoMapper.getTicketInfo(idx);
		
		return ticketInfo;
	}
	
}
