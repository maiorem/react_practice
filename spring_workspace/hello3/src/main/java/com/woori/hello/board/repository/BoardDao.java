package com.woori.hello.board.repository;

import java.util.List;

import com.woori.hello.board.domain.BoardDto;

public interface BoardDao {
	List<BoardDto> getList();
	BoardDto getView(int id);
	void insert(BoardDto dto);
}
