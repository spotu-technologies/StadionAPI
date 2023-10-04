package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BoxInfo;
import com.stadion.api.mapper.BoxInfoMapper;


@Service
public class BoxInfoService {
	@Autowired
	private BoxInfoMapper boxInfoMapper;
	
	
	public BoxInfo getBoxInfo(String userId) {
		if(boxInfoMapper==null) {return null;}
		
		BoxInfo boxInfo = boxInfoMapper.getBoxInfo(userId);
		
		return boxInfo;
	}
	public BoxInfo getBoxInfoByEmail(String emailAddress) {
		if(boxInfoMapper==null) {return null;}
		
		BoxInfo boxInfo = boxInfoMapper.getBoxInfoByEmail(emailAddress);
		
		return boxInfo;
	}

}
