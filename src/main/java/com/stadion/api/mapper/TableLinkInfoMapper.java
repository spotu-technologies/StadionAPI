package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.TableLinkInfo;

@Mapper
public interface TableLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public TableLinkInfo getTableLinkInfo(long idx);
	

}
