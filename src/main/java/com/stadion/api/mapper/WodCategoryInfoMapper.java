package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodCategoryInfo;

@Mapper
public interface WodCategoryInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodCategoryInfo getWodCategoryInfo(long idx);
	

}
