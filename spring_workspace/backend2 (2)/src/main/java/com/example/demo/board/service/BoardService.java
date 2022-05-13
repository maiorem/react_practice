package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.domain.BoardDto;





public interface BoardService {
	List<BoardDto> getList(BoardDto dto);
	BoardDto getView(long id);
	void insert(BoardDto dto);
	int getTotalCnt(BoardDto dto);
	void update(BoardDto dto);
	void delete(BoardDto dto);
}
