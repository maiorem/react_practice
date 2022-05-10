package com.example.demo.board.repository;

import java.util.List;

import com.example.demo.board.domain.BoardDto;





public interface BoardDao {
	List<BoardDto> getList(BoardDto dto);
	int getTotalCnt(BoardDto dto);
	BoardDto getView(long id);
	void insert(BoardDto dto);
	void update(BoardDto dto);
	void delete(BoardDto dto);
	
}
