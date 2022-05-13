package com.example.demo.member.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.domain.MemberDto;
import com.example.demo.member.repository.MemberDao;
import com.example.demo.member.repository.MemberDao;







@Service("MemberService")
public class MemberServiceImpl implements MemberService{

	//@Resource(name="MemberDao")
	//MemberOldDao dao;
	
	@Autowired
	private MemberDao dao;
		  
	
	@Override
	public List<MemberDto> getList(MemberDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MemberDto> getView(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MemberDto dto) {
		//dao.save(dto);
		
	}

	@Override
	public long getTotalCnt(MemberDto dto) {
		// TODO Auto-generated method stub
		//return dao.count();
		return 1;
	}

	@Override
	public void update(MemberDto dto) {
		//dao.save(dto);
		
	}

	@Override
	public void delete(MemberDto dto) {
		dao.delete(dto);
		
	}
	
}






