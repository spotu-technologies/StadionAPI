package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.GuideBoard;
import com.stadion.api.mapper.GuideBoardMapper;


@Service
public class GuideBoardService {
	@Autowired
	private GuideBoardMapper guideBoardMapper;
	
	
	public GuideBoard getGuideBoard(int idx) {
		if(guideBoardMapper==null) {return null;}
		
		GuideBoard guideBoard = guideBoardMapper.getGuideBoard(idx);
		
		return guideBoard;
	}
	
}
