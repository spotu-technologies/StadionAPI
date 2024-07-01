package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.TicketInfo;
import com.stadion.api.entity.WodBoxLinkInfo;

@Mapper
public interface WodBoxLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public WodBoxLinkInfo getWodBoxLinkInfo(long idx);
	public List<WodBoxLinkInfo> getWodBoxLinkInfoAll();
	public List<WodBoxLinkInfo> getwodBoxLinkInfoByWodIdx(Long[] arr);

}
