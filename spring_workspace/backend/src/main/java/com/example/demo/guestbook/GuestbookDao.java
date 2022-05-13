package com.example.demo.guestbook;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//ctrl-shift-o
@Repository("guestbookDao") 
public class GuestbookDao{
 
	//List<GuestbookDto> list = new ArrayList<GuestbookDto>();
	@Autowired
	SqlSessionTemplate sm;
	
	
	public List<GuestbookDto> getList() {
		
		GuestbookDto dto = new GuestbookDto();
		dto.setPg(0); 
		return sm.selectList("Guestbook_getList", dto);
	}


	public void insert(GuestbookDto dto) {
		
		sm.insert("Guestbook_insert", dto);
	}


	public GuestbookDto getView(int id) {
		
		return sm.selectOne("Guestbook_getView", id);
	}


	public void update(GuestbookDto dto) {
		sm.update("Guestbook_update", dto);
	}


	public void delete(GuestbookDto dto) {
		
		sm.update("Guestbook_delete", dto);
	}

}





