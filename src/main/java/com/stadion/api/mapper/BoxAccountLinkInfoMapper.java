package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.BoxAccountLinkInfo;

@Mapper
public interface BoxAccountLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public BoxAccountLinkInfo getBoxAccountLinkInfo(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public BoxAccountLinkInfo getBoxAccountLinkInfoByEmail(String emailAddress);
	    

}
