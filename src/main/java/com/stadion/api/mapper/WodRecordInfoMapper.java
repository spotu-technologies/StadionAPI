package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodRecordInfo;

@Mapper
public interface WodRecordInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodRecordInfo getWodRecordInfo(long idx);
	

}
