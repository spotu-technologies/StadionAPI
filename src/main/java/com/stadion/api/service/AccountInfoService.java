package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.mapper.AccountInfoMapper;

@Service
public class AccountInfoService {
	@Autowired
	private AccountInfoMapper accountInfoMapper;
	
	
	public AccountInfo getAccountInfo(String userId) {
		if(accountInfoMapper==null) {return null;}
		
		AccountInfo accountInfo = accountInfoMapper.getAccountInfo(userId);
		
		return accountInfo;
	}
	public AccountInfo getAccountInfoByEmail(String emailAddress) {
		if(accountInfoMapper==null) {return null;}
		
		AccountInfo accountInfo = accountInfoMapper.getAccountInfoByEmail(emailAddress);
		
		return accountInfo;
	}

}
