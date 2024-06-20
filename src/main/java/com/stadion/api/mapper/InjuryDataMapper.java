package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.InjuryData;
import com.stadion.api.entity.LevelData;

@Mapper
public interface InjuryDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public InjuryData getInjuryData(long idx);
	public List<InjuryData> getInjuryDataLook(long accountIdx);
	public List<InjuryData> getInjuryDataLast(long accountIdx);
	
	public int insertInjuryData(InjuryData data);

}
