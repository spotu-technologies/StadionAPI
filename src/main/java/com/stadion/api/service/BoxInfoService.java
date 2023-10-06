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
	
	
	public BoxInfo getBoxInfo(long idx) {
		if(boxInfoMapper==null) {return null;}
		
		BoxInfo boxInfo = boxInfoMapper.getBoxInfo(idx);
		
		return boxInfo;
	}
	

}
