package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WithdrawData;
import com.stadion.api.mapper.WithdrawDataMapper;


@Service
public class WithdrawDataService {
	@Autowired
	private WithdrawDataMapper withdrawDataMapper;
	
	
	public WithdrawData getWithdrawData(String userId) {
		if(withdrawDataMapper==null) {return null;}
		
		WithdrawData withdrawData = withdrawDataMapper.getWithdrawData(userId);
		
		return withdrawData;
	}
	public WithdrawData getWithdrawDataByEmail(String emailAddress) {
		if(withdrawDataMapper==null) {return null;}
		
		WithdrawData withdrawData = withdrawDataMapper.getWithdrawDataByEmail(emailAddress);
		
		return withdrawData;
	}

}
