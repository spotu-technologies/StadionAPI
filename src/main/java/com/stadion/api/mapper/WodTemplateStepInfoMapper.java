package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodTemplateStepInfo;

@Mapper
public interface WodTemplateStepInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodTemplateStepInfo getWodTemplateStepInfo(int idx);
	

}
