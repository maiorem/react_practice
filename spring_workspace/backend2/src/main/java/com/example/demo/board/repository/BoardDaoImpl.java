package com.example.demo.board.repository;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.board.domain.BoardDto;





@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{

	List<BoardDto> list = new ArrayList<BoardDto>();
	
	
	
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		return sm.selectList("Board_getList", dto);
	}

	@Override
	public BoardDto getView(long id) {
		return sm.selectOne("Board_getView",  id);
	}

	@Override
	public void insert(BoardDto dto) {

		sm.insert("Board_insert", dto);
	}

	@Override
	public int getTotalCnt(BoardDto dto) {
		
		return sm.selectOne("Board_getTotal", dto);
	}

	@Override
	public void update(BoardDto dto) {
		sm.update("Board_update", dto);
		
	}

	@Override
	public void delete(BoardDto dto) {
		sm.delete("Board_delete", dto);
		
	}

	

}






