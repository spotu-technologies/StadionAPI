package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.QnaBoard;
import com.stadion.api.mapper.QnaBoardMapper;


@Service
public class QnaBoardService {
	@Autowired
	private QnaBoardMapper qnaBoardMapper;
	
	
	public QnaBoard getQnaBoard(int idx) {
		if(qnaBoardMapper==null) {return null;}
		
		QnaBoard qnaBoard = qnaBoardMapper.getQnaBoard(idx);
		
		return qnaBoard;
	}
	
}
