package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://127.0.0.1 또는 localhost
//크롬하고 익스가 반대 --도메인이 없는 상태일때는 *로 해줘야 한다  
@CrossOrigin("*") 
//모든 데이터를 JSON 형태로 출력한다 
@RestController
public class IndexController {
	@RequestMapping("/")
	String index() {
		return "Hello Spring boot";
	}
	
	@RequestMapping("/list")  //spring framework라면 @ResponseBody RestController에서는 안붙임
	List<HashMap<String, String>> getList(){
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "홍길동");
		map.put("phone", "010-0000-0000");
		list.add(map);
		
		map = new HashMap<String, String>();
		map.put("name", "임꺽정");
		map.put("phone", "010-0000-0001");
		list.add(map);
		
		map = new HashMap<String, String>();
		map.put("name", "장길산");
		map.put("phone", "010-0000-0002");
		list.add(map);
		
		return list;
	}
}
