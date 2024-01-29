package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.BoxInfo;
import com.stadion.api.entity.CategoryInfo;
import com.stadion.api.entity.InjuryData;

@Mapper
public interface CategoryInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public CategoryInfo getCategoryInfo(long idx);
	public List<CategoryInfo> getCategoryInfoName(@Param ("tableLinkIdx") long tableLinkIdx, @Param ("depth") long depth);


}
