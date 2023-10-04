package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.FaqBoard;

@Mapper
public interface FaqBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public FaqBoard getFaqBoard(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public FaqBoard getFaqBoardByEmail(String emailAddress);
	    

}
