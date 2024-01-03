package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.PolicyBoard;

@Mapper
public interface PolicyBoardMapper {

	//public List<AccountInfo> getAccountInfoList();
	public PolicyBoard getPolicyBoard(long idx);
	public List<PolicyBoard> getPolicyBoardAll(@Param ("policyType") long policyType, @Param ("isOpen") String isOpen);
	

}
