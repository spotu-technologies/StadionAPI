package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.FaqBoard;
import com.stadion.api.mapper.AccountInfoMapper;

@Service
public class AccountInfoService {
	@Autowired
	private AccountInfoMapper accountInfoMapper;
	
	
	public AccountInfo getAccountInfo(String accountID) {
		if(accountInfoMapper==null) {return null;}
		
		AccountInfo accountInfo = accountInfoMapper.getAccountInfo(accountID);
		
		return accountInfo;
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
	
	


}
