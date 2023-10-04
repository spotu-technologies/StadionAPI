package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BoxMatchTemplateLinkInfo;
import com.stadion.api.mapper.BoxMatchTemplateLinkInfoMapper;


@Service
public class BoxMatchTemplateLinkInfoService {
	@Autowired
	private BoxMatchTemplateLinkInfoMapper boxMatchTemplateLinkInfoMapper;
	
	
	public BoxMatchTemplateLinkInfo getBoxMatchTemplateLinkInfo(String userId) {
		if(boxMatchTemplateLinkInfoMapper==null) {return null;}
		
		BoxMatchTemplateLinkInfo boxMatchTemplateLinkInfo = boxMatchTemplateLinkInfoMapper.getBoxMatchTemplateLinkInfo(userId);
		
		return boxMatchTemplateLinkInfo;
	}
	public BoxMatchTemplateLinkInfo getBoxMatchTemplateLinkInfoByEmail(String emailAddress) {
		if(boxMatchTemplateLinkInfoMapper==null) {return null;}
		
		BoxMatchTemplateLinkInfo boxMatchTemplateLinkInfo = boxMatchTemplateLinkInfoMapper.getBoxMatchTemplateLinkInfoByEmail(emailAddress);
		
		return boxMatchTemplateLinkInfo;
	}

}
