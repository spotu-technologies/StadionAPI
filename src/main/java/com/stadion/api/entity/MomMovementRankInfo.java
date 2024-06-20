package com.stadion.api.entity;

public class MomMovementRankInfo {
	
	@Override
	public String toString() {
		return "MomMovementRankInfo [idx=" + idx + ", momIdx=" + momIdx + ", movementIdx=" + movementIdx + ", sort="
				+ sort + ", writer=" + writer + ", status=" + status + ", regUnixtime=" + regUnixtime
				+ ", lastUpdatetime=" + lastUpdatetime
				+ ", levelFieldName=" + levelFieldName
				+ ", orderType=" + orderType + ", movement=" + movement
				+ ", theme=" + theme + ", flow=" + flow + "]";
	}
	public Integer idx;
	public Integer momIdx;
	public Integer movementIdx;
	public Integer sort;
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
	public String levelFieldName;
	public String orderType;
	public String movement;
	public Integer theme;
	public Integer flow;
}