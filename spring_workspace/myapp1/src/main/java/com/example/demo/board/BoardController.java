package com.example.demo.board;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*") //CORS��å���� ���� �� ��ȭ�ǰ� �ִ�
@RestController
public class BoardController {
	@Autowired 
	BoardService service;
	
	@RequestMapping("/board/list")
	HashMap<String, Object> getList()
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", service.getList());
		map.put("totalCnt", 23);
		
		return map;
	}
}






