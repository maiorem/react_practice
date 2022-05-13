package com.woori.hello.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woori.hello.board.domain.BoardDto;
import com.woori.hello.board.repository.BoardDao;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Resource(name="boardDao")
	BoardDao dao;
	@Override
	public List<BoardDto> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

	@Override
	public BoardDto getView(int id) {
		// TODO Auto-generated method stub
		return dao.getView(id);
	}

	@Override
	public void insert(BoardDto dto) {
		dao.insert(dto);
		
	}
	
}






