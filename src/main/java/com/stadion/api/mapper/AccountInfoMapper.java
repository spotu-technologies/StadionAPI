package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.FaqBoard;
import com.stadion.api.entity.LoginInfo;

@Mapper
public interface AccountInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public AccountInfo getAccountInfo(String accountID);
	public int insertAccountInfo(AccountInfo account);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public AccountInfo getAccountInfoByEmail(String emailAddress);
	
	public List<AccountInfo> getAccountInfoAll();
	public int loginAccountInfo(@Param ("idx") long idx);
	public List<AccountInfo> getAccountInfoLast(
			@Param ("start") long start, 
			@Param ("count")long count);
	public int updateAccountInfo(AccountInfo account);
	/*
			@Param ("idx") long idx, 
			@Param ("accountPW")String accountPW,
			@Param ("accountNick")String accountNick,
			@Param ("cellNumber")String cellNumber,
			
			@Param ("zipcode")String zipcode,
			@Param ("address1")String address1,
			@Param ("address2")String address2,
		
			@Param ("height")String height,
			@Param ("weight")String weight,
			@Param ("preferWeight")String preferWeight,
			
			@Param ("exercisePreferenceMode")String exercisePreferenceMode,
			
			@Param ("agreeEmail")String agreeEmail,
			@Param ("agreeSms")String agreeSms,
			@Param ("agreePush")String agreePush,
			
			@Param ("selCoach")Long selCoach,
			
			@Param ("welcomeStr")String welcomeStr,
			
			@Param ("firstMenu")Long firstMenu);
			*/

	public LoginInfo getAccountInfoLogin();
	    

}
