package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.InjuryInfo;

@Mapper
public interface InjuryInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public InjuryInfo getInjuryInfo(long idx);
	public List<InjuryInfo> getInjuryInfoAll();
	
}
