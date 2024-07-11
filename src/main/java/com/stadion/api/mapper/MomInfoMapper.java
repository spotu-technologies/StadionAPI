package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.MomInfo;
import com.stadion.api.entity.MomInfoWithFile;
import com.stadion.api.entity.MomTeamInfo;
import com.stadion.api.entity.MomTeamMemberInfo;

@Mapper
public interface MomInfoMapper {

	//public List<AccountInfo> getAccountInfoList();
	public MomInfo getMomInfo(long idx);
	public List<MomTeamInfo> getMomTeamInfoByMomIdx(long momIdx);
	public Long getMomTeamInfoIdx(@Param("leaderAccountIdx") long leaderAccountIdx, @Param("momIdx") long momIdx);
	public List<MomInfo> getMomInfoAll();
	public List<MomInfoWithFile> getMomInfoListDetail(long accountIdx);
	public List<MomTeamInfo> getMomTeamInfo(long leaderAccountIdx);
	public int insertMomTeamInfo(MomTeamInfo arg);
	public int insertMomTeamMemberInfo(MomTeamMemberInfo arg);

}
