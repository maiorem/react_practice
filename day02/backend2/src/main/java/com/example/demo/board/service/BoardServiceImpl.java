package com.example.demo.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.board.domain.BoardDto;
import com.example.demo.board.repository.BoardDao;




@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Resource(name="boardDao")
	BoardDao dao;
	@Override
	public List<BoardDto> getList(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.getList(dto);
	}

	@Override
	public BoardDto getView(long id) {
		// TODO Auto-generated method stub
		return dao.getView(id);
	}

	@Override
	public void insert(BoardDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public int getTotalCnt(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.getTotalCnt(dto);
	}

	@Override
	public void update(BoardDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void delete(BoardDto dto) {
		dao.delete(dto);
		
	}
	
}






