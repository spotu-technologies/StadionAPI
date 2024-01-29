package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MovementInfo;
import com.stadion.api.entity.WodItemInfo;

@Mapper
public interface WodItemInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItemInfo getWodItemInfo(long idx);
	public List<WodItemInfo> getWodItemInfoAll();
	

}
