package com.example.demo;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//지가 알아서 json 형태로 데이터 주고 받음
//@CrossOrigin("도메인") 또는  
//@CrossOrigin("127.0.0.1:9090")   
//@CrossOrigin("localhost:9090")
@CrossOrigin("*")
@RestController 
public class TestController {
	@RequestMapping("/")
	String test() {
		return "Hello";
	}
	
	@RequestMapping("/person")
	HashMap<String, String>getPerson()
	{
		HashMap<String, String> person=new HashMap<String, String>();
		person.put("name", "홍길동");
		person.put("phone", "010-0000-0000");
		person.put("email", "hong@hanmail.net");
		person.put("address", "서울시 서초구 양재동");
		person.put("company", "우리회사");
	
		return person;
	}
	
	
	
}
