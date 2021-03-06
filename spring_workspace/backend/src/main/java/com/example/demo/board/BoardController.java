package com.example.demo.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
	
//Access to XMLHttpRequest at 'http://localhost:9090/board/list' from origin 'http://localhost:3000' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
//@CrosOrigin("도메인")
@CrossOrigin("*")
@RestController
public class BoardController {
	
	@Resource(name="boardService")
	BoardService boardService;
	
	@RequestMapping("/board/list")
	List<BoardDto> getList(){
		System.out.println("###############################");
		BoardDto dto=new BoardDto();
		return boardService.getList(dto);
	}
	
	
	//http://localhost:9090/board/view/1 
	//board/list?id=1  => board/list/1
	@RequestMapping("/board/view/{id}")
	BoardDto getView(@PathVariable("id")int id) {
		return boardService.getView(id);
	}
	
	
	@RequestMapping("/board/insert") //@RequestBody -> JSON을 받아서 객체로 전환시킨다 
	String insert(@RequestBody BoardDto dto) {
		System.out.println("********************************");
		System.out.println(dto.getTitle());
		System.out.println(dto.getContents());
		System.out.println(dto.getWriter());
		
		
		boardService.insert(dto);
		return "success";
	}
	
	
	@RequestMapping("/board/update") //@RequestBody -> JSON을 받아서 객체로 전환시킨다 
	String update(@RequestBody BoardDto dto) {
		System.out.println(dto.getId());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContents());
		System.out.println(dto.getWriter());
		
		boardService.update(dto);
		return "success";
	}
	
	@RequestMapping("/board/delete/{id}") //@RequestBody -> JSON을 받아서 객체로 전환시킨다 
	String delete(@PathVariable("id")int id) {
		
		BoardDto dto = new BoardDto();
		dto.setId(id);
		
		boardService.delete(dto);
		return "success";
	}
	
}
