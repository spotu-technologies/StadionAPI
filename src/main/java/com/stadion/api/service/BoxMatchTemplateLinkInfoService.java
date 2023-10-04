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
	
	
	public BoxMatchTemplateLinkInfo getBoxMatchTemplateLinkInfo(int idx) {
		if(boxMatchTemplateLinkInfoMapper==null) {return null;}
		
		BoxMatchTemplateLinkInfo boxMatchTemplateLinkInfo = boxMatchTemplateLinkInfoMapper.getBoxMatchTemplateLinkInfo(idx);
		
		return boxMatchTemplateLinkInfo;
	}
	
}
