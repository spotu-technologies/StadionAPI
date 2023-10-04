package com.stadion.api.mapper;

import com.stadion.api.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {
    public List<Member> getMemberList();
    
    //@Select("SELECT * FROM Board")
    //public List<Member> getMemberList();
    //@Select("SELECT * FROM test_table")  //home WHERE name = #{name}")
    //public List<Member> getMemberList1(); // @Param("name") String name);
}