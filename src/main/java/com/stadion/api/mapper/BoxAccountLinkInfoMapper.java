package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.BoxAccountLinkInfo;

@Mapper
public interface BoxAccountLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public BoxAccountLinkInfo getBoxAccountLinkInfo(long idx);
	public int insertBoxAccountLinkInfo(BoxAccountLinkInfo arg);
	    

}
