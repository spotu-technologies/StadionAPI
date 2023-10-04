package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.TicketInfo;

@Mapper
public interface TicketInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public TicketInfo getTicketInfo(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public TicketInfo getTicketInfoByEmail(String emailAddress);
	    

}
