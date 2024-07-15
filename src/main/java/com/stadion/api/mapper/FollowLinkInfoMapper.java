package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.ActionHistory;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.FollowLinkInfo;
import com.stadion.api.entity.FollowList;

@Mapper
public interface FollowLinkInfoMapper {

	//public List<FollowLinkInfo> getgetFollowLinkInfoList();
	public List<FollowLinkInfo> getFollowLinkInfoFollow(long followAccountIdx);
	public List<FollowLinkInfo> getFollowLinkInfoReg(long regAccountIdx);
	public long getIsFollow(FollowLinkInfo arg) ;
	public long insertFollowLinkInfoFollow(FollowLinkInfo arg);
	public long deleteFollowLinkInfoFollow(FollowLinkInfo arg);
	public List<FollowList> getFollowList(long accountIdx);

}

