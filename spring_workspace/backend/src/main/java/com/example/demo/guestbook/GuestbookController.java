package com.example.demo.guestbook;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
public class GuestbookController {

	@Resource(name="guestbookService")
	GuestbookService service;
	

	@RequestMapping("/guestbook/list")
	String guestbook_list(Model model) {		
		return "/guestbook/guestbook_list";
	}
	
	@RequestMapping("/guestbook/view/{id}")
	String guestbook_view(@PathVariable("id")int id, Model model) {
		
		model.addAttribute("id", id);
		return "/guestbook/guestbook_view";
	}
	
	@RequestMapping("/guestbook/write")
	String guestbook_write(Model model) {		
		return "/guestbook/guestbook_write";
	}
	
	
	
	@RequestMapping("/guestbook/listjson")
	@ResponseBody
	List<GuestbookDto> guestbook_listjson() {
		return service.getList();
	}
	
	@RequestMapping("/guestbook/insertjson")
	HashMap<String, String> insert(@RequestBody GuestbookDto dto) {
		dto.setPg(0);
		dto.setId(0);
		System.out.println(dto.getTitle());
		System.out.println(dto.getWriter());
		
		service.insert(dto);
		HashMap<String, String> map = new HashMap<String, String>(); 
		map.put("result", "success");
		return map;
	}
	
	//http://localhost:9000/myapp/guestbook/viewjson/1
	
	@RequestMapping("/guestbook/viewjson/{id}")
	@ResponseBody
	GuestbookDto guestbook_viewjson(@PathVariable("id")int id) {
		return service.getView(id);
	}
	
	
	@RequestMapping("/guestbook/updatejson")
	String update(@RequestBody GuestbookDto dto) {
		dto.setPg(0);
		dto.setId(0);
		System.out.println(dto.getTitle());
		System.out.println(dto.getWriter());
		service.update(dto);
		return "success";
	}
	
	@RequestMapping("/guestbook/deletejson/{id}")
	String guestbook_deletejson(@PathVariable("id")int id) {
		GuestbookDto dto = new GuestbookDto();
		dto.setId(id);
		service.delete(dto);
		
		return "success";
	}
	
}







