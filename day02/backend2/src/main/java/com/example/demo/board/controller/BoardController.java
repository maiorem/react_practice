package com.example.demo.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

import com.example.demo.board.domain.BoardDto;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.FileDownload;
import com.example.demo.common.FileUploadUtil;



@CrossOrigin("*") //http:127.0.0.1 혹은 localhost
@RestController
public class BoardController {
	
	@Value("${fileUploadPath}")
	String fileUploadPath;
	
	@Value("${domain}")
	String domain;
	
	@Resource(name="boardService")
	BoardService boardService;
	
	
	@RequestMapping("/board/list/{pg}")
	HashMap<String, Object> getList(@PathVariable("pg")int pg, BoardDto dto)
	{
		//System.out.println("curpage  " + pg);
		dto.setStart((pg-1)*dto.getPageSize());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", boardService.getTotalCnt(dto));
		map.put("list",  boardService.getList(dto));
		
		return map;
	}
	
	
	@RequestMapping("/board/view/{id}")
	BoardDto getView(@PathVariable("id")long id)
	{		
		return	boardService.getView(id);
	}
	
	// Map -> HashMap의 추상클래스  -- aixos 가 json 으로 보내는데 json 받으려면 
	//@RequestBody  가 있어야 한다 
	@RequestMapping("/board/insert")
	Map<String, String> insert(MultipartFile file ,  BoardDto dto, HttpServletRequest req)
	{		
		System.out.println(dto.getTitle());
		System.out.println(dto.getWriter());
		System.out.println(dto.getContents());
		
		
		String uploadDir = fileUploadPath+ "/image" ;
		
		//http://localhost:9090/user-photos/image/1582531436.jpeg
		if(file!=null)
		{
			try {
				String filename=FileUploadUtil.upload(uploadDir, file);
				dto.setFilename(filename);
				dto.setImage_url(domain +"/"+ uploadDir + "/"+ filename);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		boardService.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	
    @GetMapping("/download/image/{file}")
    public void download(@PathVariable("file")String file, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        
	   FileDownload.download(fileUploadPath+"/image",  file, httpServletResponse);
        
    }

    @RequestMapping("/board/delete/{id}")
	Map<String, String> delete(@PathVariable("id")long id, HttpServletRequest req)
	{		
		BoardDto dto=new BoardDto();
		dto.setId(id);
		boardService.delete(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
    
    @RequestMapping("/board/update")
   	Map<String, String> update(MultipartFile file ,  BoardDto dto, HttpServletRequest req)
   	{		
   		System.out.println(dto.getTitle());
   		System.out.println(dto.getWriter());
   		System.out.println(dto.getContents());

   		
   		
   		String uploadDir = fileUploadPath+ "/image" ;
   		
   		//http://localhost:9090/user-photos/image/1582531436.jpeg
   		if(file!=null)
   		{
   			try {
   				String filename=FileUploadUtil.upload(uploadDir, file);
   				dto.setFilename(filename);
   				dto.setImage_url(domain +"/"+ uploadDir + "/"+ filename);
   				
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   		
   		//System.out.println("**********************************    "  +  dto.getId());
   		
   		boardService.update(dto);
   		Map<String, String> map = new HashMap<String, String>();
   		map.put("result", "success");
   		return map;
   	}
    
}






