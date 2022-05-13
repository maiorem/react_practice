package com.woori.highlight;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class TestController {
	@GetMapping(value="/")
	String index() {
		
		return "/index";
	}
	
	@GetMapping(value="/page1")
	String page1() {
		
		return "/page1";
	}
	
	@GetMapping(value="/page2")
	String page2() {
		
		return "/page2";
	}
	
	
	@GetMapping(value="/page3")
	String page3() {
		
		return "/page3";
	}
	
}
