package com.stadion.api.entity;

public class WodBoxInfoTime {
	
	@Override
	public String toString() {
		return "WodBoxInfoTime [wodIdx=" + wodIdx + ", progressTime=" + progressTime + ", limitCount=" + limitCount
				+ ", count=" + count + "]";
	}
	public Integer wodIdx;
	public String progressTime;
	public Integer limitCount;
	public Integer count;
	public String name;
	public String isOpen;
	public Integer wbLinkIdx;
	public Integer reserved;
	public Integer status;
	
}
