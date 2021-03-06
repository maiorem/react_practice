package com.example.demo.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDao {
	List<BoardDto> list = new ArrayList<BoardDto>();
	
	public BoardDao() {
		list.add( new BoardDto(1, "제목1", "내용1", "작성자1"));
		list.add( new BoardDto(2, "제목2", "내용2", "작성자2"));
		list.add( new BoardDto(3, "제목3", "내용3", "작성자3"));
		list.add( new BoardDto(4, "제목4", "내용4", "작성자4"));
		list.add( new BoardDto(5, "제목5", "내용5", "작성자5"));
	}
	
	List<BoardDto> getList()
	{
		return list;
	}
	
	BoardDto getView(int id)
	{
		BoardDto dto = new BoardDto();
		dto.setId(id);
		int pos = list.indexOf(dto);
		if (pos !=-1)
			return list.get(pos);
		else
			return list.get(0);
	}
	
	void update(BoardDto dto) {
		int pos = list.indexOf(dto);
		if (pos !=-1)
			list.set(pos, dto);
	}
	
	void delete(BoardDto dto) {
		int pos = list.indexOf(dto);
		if (pos !=-1)
			list.remove(pos);
	}
	
	void insert(BoardDto dto) {
		int id = list.get(list.size()-1).getId();
		dto.setId( id+1);
		list.add(dto);
		
		System.out.println(list.size());
	}
}
