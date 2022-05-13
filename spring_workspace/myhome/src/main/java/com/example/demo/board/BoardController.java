package com.example.demo.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin("*")
//@RestController 
public class BoardController {
	@Resource(name="boardDao")
	BoardDao boardDao;
	
	@RequestMapping("/board/list")
	List<BoardDto> getList(){
		return boardDao.getList();
	}
	
	// http://localhost:9090/board/delete/1
	// board/delete?_id=값
	// /board/delete/_id값
	@RequestMapping("/board/delete/{id}")
	String delete(@PathVariable("id")String id){
		
		System.out.println("id : " + id);
		boardDao.delete(id);
		
		return "deleted";
	}

	//json 형태의 데이터를 받아서 dto로 바꿔주는 어노테이션: @RequestBody
	@RequestMapping("board/insert")
	String insert(@RequestBody BoardDto dto)
	{
		System.out.println(dto.getTitle());
		System.out.println(dto.getWriter());
		System.out.println(dto.getContents());
		
		boardDao.insert(dto);
		
		return "success";
		
	}
	
	@RequestMapping("board/view/{_id}")
	BoardDto getView(@PathVariable("_id")String _id) {
		System.out.println("_id " + _id);
		return boardDao.getView(_id);
	}

	@RequestMapping("board/update")
	String update(@RequestBody BoardDto dto) {
		System.out.println(dto.get_id());
		boardDao.update(dto);
		
		return "success";
	}
	
}
