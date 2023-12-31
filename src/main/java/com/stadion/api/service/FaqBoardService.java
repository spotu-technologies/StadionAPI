package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.FaqBoard;
import com.stadion.api.mapper.FaqBoardMapper;


@Service
public class FaqBoardService {
	@Autowired
	private FaqBoardMapper faqBoardMapper;
	
	public List<FaqBoard> getFaqBoardAll() {
		if(faqBoardMapper==null) {return null;}
		
		List<FaqBoard> faqBoardList = faqBoardMapper.getFaqBoardAll();
		
		return faqBoardList;
	}
	
	
	public FaqBoard getFaqBoard(long idx) {
		if(faqBoardMapper==null) {return null;}
		
		FaqBoard faqBoard = faqBoardMapper.getFaqBoard(idx);
		
		return faqBoard;
	}
	
}
