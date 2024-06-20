package com.stadion.api.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.FaqBoard;
import com.stadion.api.entity.LoginInfo;
import com.stadion.api.mapper.AccountInfoMapper;

@Service
public class AccountInfoService {
	@Autowired
	private AccountInfoMapper accountInfoMapper;
	
	
	public int loginAccountInfo(@Param ("idx") long idx) 
	{
		if(accountInfoMapper==null) {return 0;}
		
		int ret = accountInfoMapper.loginAccountInfo(idx);
		
		return ret;
	}
	public int updateAccountInfo(AccountInfo account
			/*@Param ("idx") long idx, 
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
			
			@Param ("firstMenu")Long firstMenu*/) {
		if(accountInfoMapper==null) {return 0;}
		
		int ret = accountInfoMapper.updateAccountInfo(account);
				/*idx, accountPW, accountNick,
				cellNumber,	zipcode,address1, address2, height, weight, preferWeight,
				exercisePreferenceMode, agreeEmail, agreeSms, agreePush,
				selCoach, welcomeStr, firstMenu);*/
		
		return ret;
	}
	public AccountInfo getAccountInfo(String accountID) {
		if(accountInfoMapper==null) {return null;}
		
		AccountInfo accountInfo = accountInfoMapper.getAccountInfo(accountID);
		
		return accountInfo;
	}
		
	public int insertAccountInfo(AccountInfo account) 
	{
		if(accountInfoMapper==null) {return 0;}		
		return accountInfoMapper.insertAccountInfo(account);
	}
	
	public AccountInfo getAccountInfoByEmail(String emailAddress) {
		if(accountInfoMapper==null) {return null;}
		
		AccountInfo accountInfo = accountInfoMapper.getAccountInfoByEmail(emailAddress);
		
		return accountInfo;
	}
	
	public List<AccountInfo> getAccountInfoAll() {
		if(accountInfoMapper==null) {return null;}
		
		List<AccountInfo> accountInfoList = accountInfoMapper.getAccountInfoAll();
		
		return accountInfoList;
	}
	
	public List<AccountInfo> getAccountInfoLast(long start, long count) {
		if(accountInfoMapper==null) {return null;}
		
		List<AccountInfo> accountInfoList = accountInfoMapper.getAccountInfoLast(start, count);
		
		return accountInfoList;
	}
	
	public LoginInfo getAccountInfoLogin() {
		if(accountInfoMapper==null) {return null;}
		
		LoginInfo accountInfoList = accountInfoMapper.getAccountInfoLogin();
		
		return accountInfoList;
	}
	
	


}
