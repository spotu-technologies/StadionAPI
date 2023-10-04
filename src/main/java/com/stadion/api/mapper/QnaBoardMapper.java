package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.QnaBoard;

@Mapper
public interface QnaBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public QnaBoard getQnaBoard(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public QnaBoard getQnaBoardByEmail(String emailAddress);
	    

}
