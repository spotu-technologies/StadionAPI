package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.MomMovementLinkInfo;

@Mapper
public interface MomMovementLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MomMovementLinkInfo getMomMovementLinkInfo(int idx);
	

}
