package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodTemplateInfo;

@Mapper
public interface WodTemplateInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodTemplateInfo getWodTemplateInfo(long idx);
	

}
