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
	
	
	public BoxAccountLinkInfo getBoxAccountLinkInfo(String userId) {
		if(boxAccountLinkInfoMapper==null) {return null;}
		
		BoxAccountLinkInfo boxAccountLinkInfo = boxAccountLinkInfoMapper.getBoxAccountLinkInfo(userId);
		
		return boxAccountLinkInfo;
	}
	public BoxAccountLinkInfo getBoxAccountLinkInfoByEmail(String emailAddress) {
		if(boxAccountLinkInfoMapper==null) {return null;}
		
		BoxAccountLinkInfo boxAccountLinkInfo = boxAccountLinkInfoMapper.getBoxAccountLinkInfoByEmail(emailAddress);
		
		return boxAccountLinkInfo;
	}

}
