package com.example.demo.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.domain.BoardDto;
import com.example.demo.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired 
	BoardService service;
	
	
	//http://localhost:9090/board/list?page=0&size=5
	@RequestMapping("/board/list")
	List<BoardDto> getList(BoardDto board, Pageable pageable)
	{
		
		return service.getList(board, pageable);
	}
	
	
	//http://localhost:9090/board/write?title=test1&writer=w1&contents=c1&hits=0
	@RequestMapping("/board/write")
	String  write(BoardDto board)
	{
		 service.write(board);
		 return "success";
	}
	
	@RequestMapping("/board/delete/{id}")
	String  delete(BoardDto board, @PathVariable long id)
	{
		System.out.println(board.getId());
		 service.delete(board);
		 return "success";
	}
	
	
	//http://localhost:9090/board/update?title=test1&writer=w1&contents=c1&hits=0&id=3
	@RequestMapping("/board/update")
	String  update(BoardDto board)
	{
		 service.write(board);
		 return "success";
	}
	
	
}
