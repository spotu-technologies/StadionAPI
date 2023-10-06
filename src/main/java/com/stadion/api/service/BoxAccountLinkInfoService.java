package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BoxAccountLinkInfo;
import com.stadion.api.mapper.BoxAccountLinkInfoMapper;


@Service
public class BoxAccountLinkInfoService {
	@Autowired
	private BoxAccountLinkInfoMapper boxAccountLinkInfoMapper;
	
	
	public BoxAccountLinkInfo getBoxAccountLinkInfo(long idx) {
		if(boxAccountLinkInfoMapper==null) {return null;}
		
		BoxAccountLinkInfo boxAccountLinkInfo = boxAccountLinkInfoMapper.getBoxAccountLinkInfo(idx);
		
		return boxAccountLinkInfo;
	}
	
}
