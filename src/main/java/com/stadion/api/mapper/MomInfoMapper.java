package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MomInfo;

@Mapper
public interface MomInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MomInfo getMomInfo(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public MomInfo getMomInfoByEmail(String emailAddress);
	    

}
