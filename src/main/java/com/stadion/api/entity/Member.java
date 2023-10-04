package com.stadion.api.entity;

import org.springframework.stereotype.Repository;

import lombok.Data;


@Data
@Repository
public class Member {
	private Integer seq;
	private String name;

}
