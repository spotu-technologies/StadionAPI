package com.stadion.api.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountInfo {
	
	public int getAge() throws ParseException {
		int age = 0;
		
		try {
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	Date date = new Date();        	
	    	Date dt = dateFormat.parse(getBirthday());
	    	age = date.getYear() - dt.getYear() 	;//Integer.parseInt(dateFormat.format(ai.birthday));
		}
		catch(Exception ex) {
			System.out.println("Exception while calculate age " + ex.toString());
		}

    	return age;
	}
	public String getBirthday() {return birthday;}

	@Override
	public String toString() {
		return "AccountInfo [idx=" + idx + ", accountID=" + accountID + ", accountPW=" + accountPW + ", accountName="
				+ accountName + ", accountNick=" + accountNick + ", cellNumber=" + cellNumber + ", emailAddress="
				+ emailAddress + ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2
				+ ", regionGroup=" + regionGroup + ", gender=" + gender + ", birthday=" + birthday + ", birthdayType="
				+ birthdayType + ", ageGroup=" + ageGroup + ", height=" + height + ", heightGroup=" + heightGroup
				+ ", weight=" + weight + ", weightGroup=" + weightGroup + ", preferWeight=" + preferWeight
				+ ", preferDistance=" + preferDistance + ", preferHeight=" + preferHeight + ", recommenderIdx="
				+ recommenderIdx + ", joinFrom=" + joinFrom + ", exercisePreferenceMode=" + exercisePreferenceMode
				+ ", pwdFailCount=" + pwdFailCount + ", isSuper=" + isSuper + ", permission=" + permission
				+ ", explanation=" + explanation + ", isEmailAuth=" + isEmailAuth + ", isRest=" + isRest + ", isOpen="
				+ isOpen + ", agreeEmail=" + agreeEmail + ", agreeSms=" + agreeSms + ", agreePush=" + agreePush
				+ ", writer=" + writer + ", status=" + status + ", regUnixtime=" + regUnixtime + ", lastUpdatetime="
				+ lastUpdatetime + ", mailUnixtime=" + mailUnixtime + ", lastLoginUnixtime=" + lastLoginUnixtime
				+ ", passwordUnixtime=" + passwordUnixtime + ", withdrawUnixtime=" + withdrawUnixtime
				+ ", lastRecordUnixtime=" + lastRecordUnixtime + ", restUnixtime=" + restUnixtime + ", selCoach="
				+ selCoach + ", welcomeStr=" + welcomeStr + ", firstMenu=" + firstMenu + "]";
	}
	public Integer idx;
	public String accountID;
	public String accountPW; // 비밀번호
	public String accountName;
	public String accountNick;
	
	
	public String cellNumber; // 휴대폰 번호
	public String emailAddress;
	public String zipcode; // 우편번호
	public String address1; // 주소 동까지
	public String address2; // 주소 상세
	public String regionGroup;
	public String gender;
	public String birthday;
	public String birthdayType;
	public Integer ageGroup;
	public String height; // 신장
	public Integer heightGroup;
	public String weight; // 체중 -> bwHistory (체중 히스토리)
	public Integer weightGroup;
	public String preferWeight; // 체중 단위
	public String preferDistance;
	public String preferHeight;
	
	public Integer recommenderIdx;
	public String joinFrom;
	public String exercisePreferenceMode; // 운동 선호도 1-0-0 형식, |**| 로 구분
	public Integer pwdFailCount;
	public String isSuper;
	public Integer permission;
	public String explanation;
	public String isEmailAuth;
	public String isRest;
	public String isOpen;
	public String agreeEmail; // 정보 수신 동의 Y/N
	public String agreeSms;  // Y/N
	public String agreePush; // Y/N
	
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
	public Integer mailUnixtime;
	public Integer lastLoginUnixtime;
	public Integer passwordUnixtime;
	public Integer withdrawUnixtime;
	public Integer lastRecordUnixtime;
	public Integer restUnixtime;
	public Integer selCoach; // 코치마크 on/off
	public String welcomeStr; // 인사말
	public Integer firstMenu;// 초기화면 선택

	
}
