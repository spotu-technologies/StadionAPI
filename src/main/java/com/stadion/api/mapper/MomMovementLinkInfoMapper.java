package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MomMovementLinkInfo;
import com.stadion.api.entity.MomMovementRankInfo;

@Mapper
public interface MomMovementLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MomMovementLinkInfo getMomMovementLinkInfo(long idx);
	public List<MomMovementRankInfo>  getMomMovementRankInfo(long idx);
	

}
