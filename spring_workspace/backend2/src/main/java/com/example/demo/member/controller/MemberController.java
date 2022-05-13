package com.example.demo.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.common.FileDownload;
import com.example.demo.common.FileUploadUtil;
import com.example.demo.member.domain.MemberDto;
import com.example.demo.member.service.MemberService;



@CrossOrigin("*") 
@RestController   
public class MemberController {
	
	@Value("${fileUploadPath}")   
	String fileUploadPath;
	
	@Value("${domain}")
	String domain;
	
	@Resource(name="MemberService")
	MemberService memberService;
	
	
	@RequestMapping("/Member/list/{pg}")  //  /Member/list/1
	HashMap<String, Object> getList(@PathVariable("pg")int pg, MemberDto dto)
	{
		//System.out.println("curpage  " + pg);
		dto.setStart((pg-1)*dto.getPageSize());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", memberService.getTotalCnt(dto));
		map.put("list",  memberService.getList(dto));
		
		return map;
	}
	
	
	@RequestMapping("/Member/view/{id}")
	Optional<MemberDto> getView(@PathVariable("id")long id)
	{		
		Optional<MemberDto> result = memberService.getView(id);
		return	result;
	}
	
	// Map -> HashMap�� �߻�Ŭ����  -- aixos �� json ���� �����µ� json �������� 
	//@RequestBody  �� �־�� �Ѵ� 
	@RequestMapping("/Member/insert")
	Map<String, String> insert(MultipartFile file ,  MemberDto dto, HttpServletRequest req)
	{		
			
		memberService.insert(dto);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	
   

    @RequestMapping("/Member/delete/{id}")
	Map<String, String> delete(@PathVariable("id")long id, HttpServletRequest req)
	{		
		MemberDto dto=new MemberDto();
		dto.setId(id);
		System.out.println("������ ���̵� : " + id);
		memberService.delete(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
    
    @RequestMapping("/Member/update")
   	Map<String, String> update( MemberDto dto, HttpServletRequest req)
   	{		
   			
   		
   		//System.out.println("**********************************    "  +  dto.getId());
   		
   		memberService.update(dto);
   		Map<String, String> map = new HashMap<String, String>();
   		map.put("result", "success");
   		return map;
   	}
    
}






