package com.example.demo.member.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.member.domain.MemberDto;



public interface MemberService {
	List<MemberDto> getList(MemberDto dto);
	Optional<MemberDto> getView(long id);
	void insert(MemberDto dto);
	long getTotalCnt(MemberDto dto);
	void update(MemberDto dto);
	void delete(MemberDto dto);
}
