package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.BoxMatchTemplateLinkInfo;

@Mapper
public interface BoxMatchTemplateLinkInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public BoxMatchTemplateLinkInfo getBoxMatchTemplateLinkInfo(int idx);
	    

}
