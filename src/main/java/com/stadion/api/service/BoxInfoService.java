package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BoxInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.mapper.BoxInfoMapper;


@Service
public class BoxInfoService {
	@Autowired
	private BoxInfoMapper boxInfoMapper;
	
	public List<BoxInfo> getBoxInfoAll() {
		if(boxInfoMapper==null) {return null;}
		
		List<BoxInfo> boxInfoList = boxInfoMapper.getBoxInfoAll();
		
		return boxInfoList;
	}
	
	public BoxInfo getBoxInfo(long idx) {
		if(boxInfoMapper==null) {return null;}
		
		BoxInfo boxInfo = boxInfoMapper.getBoxInfo(idx);
		
		return boxInfo;
	}
	

}
