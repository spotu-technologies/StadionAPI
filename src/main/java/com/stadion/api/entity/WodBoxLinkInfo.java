package com.stadion.api.entity;

public class WodBoxLinkInfo {
	
	@Override
	public String toString() {
		return "WodBoxLinkInfo [idx=" + idx + ", wodIdx=" + wodIdx + ", boxIdx=" + boxIdx + ", coachIdx=" + coachIdx
				+ ", progressTime=" + progressTime + ", limitCount=" + limitCount + ", writer=" + writer + ", status="
				+ status + ", regUnixtime=" + regUnixtime + ", lastUpdatetime=" + lastUpdatetime + ", demoCount="
				+ demoCount + "]";
	}
	public Integer idx;
	public Integer wodIdx;
	public Integer boxIdx;
	public Integer coachIdx;
	public String progressTime;
	public Integer limitCount;
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
	public Integer demoCount;
}
