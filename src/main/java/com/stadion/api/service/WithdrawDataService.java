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
	
	
	public WithdrawData getWithdrawData(long idx) {
		if(withdrawDataMapper==null) {return null;}
		
		WithdrawData withdrawData = withdrawDataMapper.getWithdrawData(idx);
		
		return withdrawData;
	}
	
}
