package com.example.demo.board2;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController 
public class Board2Controller {
	@Resource(name="board2Dao")
	Board2Dao board2Dao;
	
	@RequestMapping("/board/list")
	List<Board2Dto> getList(){
		return board2Dao.getList();
	}
	
	// http://localhost:9090/board/delete/1
	// board/delete?_id=값
	// /board/delete/_id값
	@RequestMapping("/board/delete/{_id}")
	String delete(@PathVariable("_id")int _id){
		
		System.out.println("id : " + _id);
		board2Dao.delete(_id);
		
		return "deleted";
	}

	//json 형태의 데이터를 받아서 dto로 바꿔주는 어노테이션: @RequestBody
	@RequestMapping("board/insert")
	String insert(@RequestBody Board2Dto dto)
	{
		System.out.println(dto.getTitle());
		System.out.println(dto.getWriter());
		System.out.println(dto.getContents());
		
		board2Dao.insert(dto);
		
		return "success";
		
	}
	
	@RequestMapping("board/view/{_id}")
	Board2Dto getView(@PathVariable("_id")int _id) {
		System.out.println("id " + _id);
		return board2Dao.getView(_id);
	}

	@RequestMapping("board/update")
	String update(@RequestBody Board2Dto dto) {
		System.out.println(dto.getId());
		//dto.setId(dto.get_id());
		board2Dao.update(dto);
		
		return "success";
	}
	
}
