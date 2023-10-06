package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.InjuryData;

@Mapper
public interface InjuryDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public InjuryData getInjuryData(long idx);
	

}
