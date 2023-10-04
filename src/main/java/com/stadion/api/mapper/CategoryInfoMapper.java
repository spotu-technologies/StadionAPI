package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.CategoryInfo;

@Mapper
public interface CategoryInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public CategoryInfo getCategoryInfo(int idx);


}
