package com.example.demo.board2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository("board2Dao")
public class Board2Dao {
	List<Board2Dto> list = new ArrayList<Board2Dto>();
	public  Board2Dao()
	{
		list.add( new Board2Dto(1, "제목1", "내용1", "작성자1"));
		list.add( new Board2Dto(2, "제목2", "내용2", "작성자2"));
		list.add( new Board2Dto(3, "제목3", "내용3", "작성자3"));
		list.add( new Board2Dto(4, "제목4", "내용4", "작성자4"));
		list.add( new Board2Dto(5, "제목5", "내용5", "작성자5"));
	}
	public List<Board2Dto> getList()
	{
		return list;
	}
	
	public void delete(int id)
	{
		
		list.remove(id-1);
	}
	
	public void insert(Board2Dto dto) {
		int seq = list.size()+1;
		dto.setId(seq);
		list.add(dto);
 	}
	
	
	public Board2Dto getView(int id)
	{
		
		Board2Dto dto = list.get(id-1);
		
		return dto;
	}
	
	public void update(Board2Dto dto) {
		System.out.println("*********" + dto.getId());
		list.set(dto.getId()-1, dto) ;
 	}
}
