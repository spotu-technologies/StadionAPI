package com.stadion.api.entity;

import org.apache.ibatis.annotations.Param;

public class RankingDataParameter {
	
	@Override
	public String toString() {
		return "RankingDataParameter [momIdx=" + momIdx + ", wodIdx=" + wodIdx + ", boxIdx=" + boxIdx + ", scale="
				+ scale + ", levelField=" + levelField + ", orderType=" + orderType + ", year=" + year + ", start="
				+ start + ", count=" + count + ", minMax=" + minMax + ", gender=" + gender + ", region=" + region
				+ ", age=" + age + ", weight=" + weight + "]";
	}
	public long momIdx;
	public long wodIdx;
	public long boxIdx;
	public long scale;
	public String levelField;
	public String orderType;
	public long year;
	public long start;
	public long count;
	public String minMax;
	public String gender;
	public String region;
	public long age;
	public long weight;
	
}
