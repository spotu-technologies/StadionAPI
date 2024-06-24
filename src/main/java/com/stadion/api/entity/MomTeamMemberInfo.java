package com.stadion.api.entity;

public class MomTeamMemberInfo {
	@Override
	public String toString() {
		return "MomTeamMemberInfo [idx=" + idx + ", momIdx=" + momIdx + ", momTeamIdx=" + momTeamIdx + ", accountIdx="
				+ accountIdx + ", status=" + status + ", regAccountIdx=" + regAccountIdx + ", regUnixtime="
				+ regUnixtime + ", lastUpdatetime=" + lastUpdatetime + "]";
	}
	public Integer idx;
	public Integer momIdx;
	public Integer momTeamIdx;
	public Integer accountIdx;
	public Integer status;
	public Integer regAccountIdx;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
}
