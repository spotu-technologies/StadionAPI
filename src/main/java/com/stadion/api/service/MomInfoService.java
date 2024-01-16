package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.MomInfo;
import com.stadion.api.mapper.MomInfoMapper;


@Service
public class MomInfoService {
	@Autowired
	private MomInfoMapper momInfoMapper;
	
	public List<MomInfo> getMomInfoAll() {
		if(momInfoMapper==null) {return null;}
		
		List<MomInfo> momInfoList = momInfoMapper.getMomInfoAll();
		
		return momInfoList;
	}
	
	
	public MomInfo getMomInfo(long idx) {
		if(momInfoMapper==null) {return null;}
		
		MomInfo momInfo = momInfoMapper.getMomInfo(idx);
		
		return momInfo;
	}
	
}
