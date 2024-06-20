package com.stadion.api.entity;

public class InjuryData {

	@Override
	public String toString() {
		return "InjuryData [idx=" + idx + ", tableLinkIdx=" + tableLinkIdx + ", pIdx=" + pIdx + ", accountIdx="
				+ accountIdx + ", injuryPartIdx=" + injuryPartIdx + ", injuryExtentIdx=" + injuryExtentIdx
				+ ", injuryTreatIdx=" + injuryTreatIdx + ", content=" + content + ", writer=" + writer + ", status="
				+ status + ", regUnixtime=" + regUnixtime + ", lastUpdatetime=" + lastUpdatetime + "]";
	}
	public Integer idx;
	public Integer tableLinkIdx;
	public Integer pIdx;
	public Integer accountIdx;
	public Integer injuryPartIdx;
	public Integer injuryExtentIdx;
	public Integer injuryTreatIdx;
	public String content;
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
}
