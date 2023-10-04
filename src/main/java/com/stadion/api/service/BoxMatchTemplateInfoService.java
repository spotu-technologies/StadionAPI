package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.BoxMatchTemplateInfo;
import com.stadion.api.mapper.BoxMatchTemplateInfoMapper;


@Service
public class BoxMatchTemplateInfoService {
	@Autowired
	private BoxMatchTemplateInfoMapper boxMatchTemplateInfoMapper;
	
	
	public BoxMatchTemplateInfo getBoxMatchTemplateInfo(String userId) {
		if(boxMatchTemplateInfoMapper==null) {return null;}
		
		BoxMatchTemplateInfo boxMatchTemplateInfo = boxMatchTemplateInfoMapper.getBoxMatchTemplateInfo(userId);
		
		return boxMatchTemplateInfo;
	}
	public BoxMatchTemplateInfo getBoxMatchTemplateInfoByEmail(String emailAddress) {
		if(boxMatchTemplateInfoMapper==null) {return null;}
		
		BoxMatchTemplateInfo boxMatchTemplateInfo = boxMatchTemplateInfoMapper.getBoxMatchTemplateInfoByEmail(emailAddress);
		
		return boxMatchTemplateInfo;
	}

}
