package com.example.demo.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	List<BoardDto> list = new ArrayList<BoardDto>();
	
	public BoardDao() {
		for(int i=0; i<=25; i++)
		{
			list.add( new BoardDto(i,"제목"+i, "내용"+i, "작성자"+i, "2022-05-"+i));
		}
	}
	
	List<BoardDto> getList(){
		return list;
	}
}
