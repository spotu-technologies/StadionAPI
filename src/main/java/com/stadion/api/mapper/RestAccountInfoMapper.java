package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.RestAccountInfo;

@Mapper
public interface RestAccountInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public RestAccountInfo getRestAccountInfo(int idx);
	  

}
