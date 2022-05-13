package com.example.demo.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.example.demo.common.BaseDto;

import lombok.AccessLevel;
import lombok.Builder;
    
@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)  
public class MemberDto extends BaseDto{
	    
	private long id=-1;
	private String username="";
	private String userid="";
	private String password="";
	private String email="";
	
	 
	@Builder
	public MemberDto(long id, String username, String userid, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.userid = userid;
		this.password = password;
		this.email = email;

	}
	
	
}
