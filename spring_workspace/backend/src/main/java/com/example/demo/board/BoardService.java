package com.example.demo.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardService {
	@Resource(name="boardDao")
	BoardDao boardDao;
	
	List<BoardDto> getList(BoardDto dto){
		return boardDao.getList();
	}
	
	BoardDto getView(int id) {
		return boardDao.getView(id);
	}
	
	void insert(BoardDto dto) {
		boardDao.insert(dto);
	}
	
	void update(BoardDto dto) {
		boardDao.update(dto);
	}
	
	void delete(BoardDto dto) {
		boardDao.delete(dto);
	}
}
