package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.CategoryInfo;

@Mapper
public interface CategoryInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public CategoryInfo getCategoryInfo(String accountID);
	
	//이메일 주소로 아이디 찾기가 필요하다면..
	public CategoryInfo getCategoryInfoByEmail(String emailAddress);
	    

}
