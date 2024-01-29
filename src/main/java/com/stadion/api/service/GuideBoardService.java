package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.FaqBoard;
import com.stadion.api.entity.GuideBoard;
import com.stadion.api.mapper.GuideBoardMapper;


@Service
public class GuideBoardService {
	@Autowired
	private GuideBoardMapper guideBoardMapper;
	
	public List<GuideBoard> getGuideBoardAll() {
		if(guideBoardMapper==null) {return null;}
		
		List<GuideBoard> guideBoardList = guideBoardMapper.getGuideBoardAll();
		
		return guideBoardList;
	}
	
	
	public GuideBoard getGuideBoard(long idx) {
		if(guideBoardMapper==null) {return null;}
		
		GuideBoard guideBoard = guideBoardMapper.getGuideBoard(idx);
		
		return guideBoard;
	}
	
}
