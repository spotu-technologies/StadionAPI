package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodTemplateRecordInfo;

@Mapper
public interface WodTemplateRecordInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodTemplateRecordInfo getWodTemplateRecordInfo(long idx);
	

}
