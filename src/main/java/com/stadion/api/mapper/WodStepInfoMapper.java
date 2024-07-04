package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.WodStepInfo;

@Mapper
public interface WodStepInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodStepInfo getWodStepInfo(long idx);
	public List<WodStepInfo> getWodStepInfoByWodIdx(long wodIdx);
	

}
