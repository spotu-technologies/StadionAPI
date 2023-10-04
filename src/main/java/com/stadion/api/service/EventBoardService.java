package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.EventBoard;
import com.stadion.api.mapper.EventBoardMapper;


@Service
public class EventBoardService {
	@Autowired
	private EventBoardMapper eventBoardMapper;
	
	
	public EventBoard getEventBoard(String userId) {
		if(eventBoardMapper==null) {return null;}
		
		EventBoard eventBoard = eventBoardMapper.getEventBoard(userId);
		
		return eventBoard;
	}
	public EventBoard getEventBoardByEmail(String emailAddress) {
		if(eventBoardMapper==null) {return null;}
		
		EventBoard eventBoard = eventBoardMapper.getEventBoardByEmail(emailAddress);
		
		return eventBoard;
	}

}
