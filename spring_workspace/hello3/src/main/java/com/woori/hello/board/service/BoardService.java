package com.woori.hello.board.service;

import java.util.List;

import com.woori.hello.board.domain.BoardDto;

public interface BoardService {
	List<BoardDto> getList();
	BoardDto getView(int id);
	void insert(BoardDto dto);
}
