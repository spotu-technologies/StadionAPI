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
	
	
	public EventBoard getEventBoard(long idx) {
		if(eventBoardMapper==null) {return null;}
		
		EventBoard eventBoard = eventBoardMapper.getEventBoard(idx);
		
		return eventBoard;
	}
	
}
