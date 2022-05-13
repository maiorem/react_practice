package com.example.demo.member.repository;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.member.domain.MemberDto;







@Repository("MemberDao")
public class MemberDaoImpl implements MemberDao{

	List<MemberDto> list = new ArrayList<MemberDto>();
	
	
	
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<MemberDto> getList(MemberDto dto) {
		
		return sm.selectList("Member_getList", dto);
	}

	@Override
	public MemberDto getView(long id) {
		return sm.selectOne("Member_getView",  id);
	}

	@Override
	public void insert(MemberDto dto) {

		sm.insert("Member_insert", dto);
	}

	@Override
	public int getTotalCnt(MemberDto dto) {
		
		return sm.selectOne("Member_getTotal", dto);
	}

	@Override
	public void update(MemberDto dto) {
		sm.update("Member_update", dto);
		
	}

	@Override
	public void delete(MemberDto dto) {
		sm.delete("Member_delete", dto);
		
	}

	

}






