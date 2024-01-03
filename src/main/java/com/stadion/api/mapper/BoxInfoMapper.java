package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.BoxInfo;
import com.stadion.api.entity.EventBoard;

@Mapper
public interface BoxInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public BoxInfo getBoxInfo(long idx);
	public List<BoxInfo> getBoxInfoAll();
	

}
