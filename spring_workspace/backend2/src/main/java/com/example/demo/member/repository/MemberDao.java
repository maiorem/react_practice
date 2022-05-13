package com.example.demo.member.repository;

import java.util.List;

import com.example.demo.member.domain.MemberDto;






public interface MemberDao {
	List<MemberDto> getList(MemberDto dto);
	int getTotalCnt(MemberDto dto);
	MemberDto getView(long id);
	void insert(MemberDto dto);
	void update(MemberDto dto);
	void delete(MemberDto dto);
	
}
