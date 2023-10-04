package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MomInfo;
import com.stadion.api.mapper.MomInfoMapper;


@Service
public class MomInfoService {
	@Autowired
	private MomInfoMapper momInfoMapper;
	
	
	public MomInfo getMomInfo(String userId) {
		if(momInfoMapper==null) {return null;}
		
		MomInfo momInfo = momInfoMapper.getMomInfo(userId);
		
		return momInfo;
	}
	public MomInfo getMomInfoByEmail(String emailAddress) {
		if(momInfoMapper==null) {return null;}
		
		MomInfo momInfo = momInfoMapper.getMomInfoByEmail(emailAddress);
		
		return momInfo;
	}

}
