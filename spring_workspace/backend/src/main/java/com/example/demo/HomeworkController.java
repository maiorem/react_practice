package com.example.demo;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller 
public class HomeworkController {
	@RequestMapping("/login_proc")
	@ResponseBody
	HashMap<String, String> login_proc(String userid, String password)
	{
		HashMap<String, String> map = new HashMap<String, String>();
		if(userid.equals("abc") && password.equals("1234"))
			map.put("result", "success");
		else
			map.put("result", "fail");
		return map;
	}
	
	@RequestMapping("/login")
	String login()
	{
		System.out.println("************************************");
		return "/homework";
	}
}
