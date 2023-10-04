package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodItemInfo;

@Mapper
public interface WodItemInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodItemInfo getWodItemInfo(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public WodItemInfo getWodItemInfoByEmail(String emailAddress);
	    

}
