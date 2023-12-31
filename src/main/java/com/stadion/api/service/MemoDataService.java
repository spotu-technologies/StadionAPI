package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MemoData;
import com.stadion.api.mapper.MemoDataMapper;


@Service
public class MemoDataService {
	@Autowired
	private MemoDataMapper memoDataMapper;
	
	
	public MemoData getMemoData(long idx) {
		if(memoDataMapper==null) {return null;}
		
		MemoData memoData = memoDataMapper.getMemoData(idx);
		
		return memoData;
	}
	
}
