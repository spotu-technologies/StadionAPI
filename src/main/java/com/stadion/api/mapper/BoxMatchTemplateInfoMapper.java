package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.BoxMatchTemplateInfo;

@Mapper
public interface BoxMatchTemplateInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public BoxMatchTemplateInfo getBoxMatchTemplateInfo(long idx);
	

}
