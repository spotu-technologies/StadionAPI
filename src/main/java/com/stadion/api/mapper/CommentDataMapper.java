package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.CommentData;

@Mapper
public interface CommentDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public CommentData getCommentData(long idx);
	

}
