package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.TokenData;

@Mapper
public interface TokenDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public TokenData getTokenData(long idx);
	  

}
