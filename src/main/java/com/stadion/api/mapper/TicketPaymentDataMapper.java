package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.TicketPaymentData;

@Mapper
public interface TicketPaymentDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public TicketPaymentData getTicketPaymentData(int idx);
	

}
