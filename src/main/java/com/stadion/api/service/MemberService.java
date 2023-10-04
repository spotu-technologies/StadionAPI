package com.stadion.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.Member;
import com.stadion.api.mapper.MemberMapper;

@Service
//public interface MemberService {
//public abstract List<Member> getMember() throws Exception;
public class MemberService {	
	@Autowired //(required=false)
	private MemberMapper memberMapper;
	
	
	public List<Member> getMember() {
		if(memberMapper==null) {return null;}
		
		List<Member> member = memberMapper.getMemberList();
		
		return member;
	}

}