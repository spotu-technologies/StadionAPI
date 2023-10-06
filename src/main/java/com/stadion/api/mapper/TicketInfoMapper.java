package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.TicketInfo;

@Mapper
public interface TicketInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public TicketInfo getTicketInfo(long idx);
	

}
