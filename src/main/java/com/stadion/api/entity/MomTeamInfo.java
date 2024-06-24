package com.stadion.api.entity;

public class MomTeamInfo {
	@Override
	public String toString() {
		return "MomTeamInfo [idx=" + idx + ", momIdx=" + momIdx + ", name=" + name + ", leaderAccountIdx="
				+ leaderAccountIdx + ", status=" + status + ", regAccountIdx=" + regAccountIdx + ", regUnixtime="
				+ regUnixtime + ", lastUpdatetime=" + lastUpdatetime + "]";
	}
	public Integer idx;
	public Integer momIdx;
	public String name;
	public Integer leaderAccountIdx;
	public Integer status;
	public Integer regAccountIdx;
	public Integer regUnixtime;
	public Integer lastUpdatetime;

}
