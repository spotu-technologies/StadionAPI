package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MovementPointData;

@Mapper
public interface MovementPointDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MovementPointData getMovementPointData(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public MovementPointData getMovementPointDataByEmail(String emailAddress);
	    

}
