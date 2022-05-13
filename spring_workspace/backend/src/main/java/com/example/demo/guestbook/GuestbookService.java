package com.example.demo.guestbook;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("guestbookService")
public class GuestbookService{
	@Resource(name="guestbookDao")
	GuestbookDao guestbookDao;

	
	public List<GuestbookDto> getList() {
		
		return guestbookDao.getList();
	}

	
	public void insert(GuestbookDto dto) {
		guestbookDao.insert(dto);
		
	}

	public GuestbookDto getView(int id) {
		
		return guestbookDao.getView(id);
	}


	public void update(GuestbookDto dto) {
		
		guestbookDao.update(dto);
		
	}

	
	public void delete(GuestbookDto dto) {
		guestbookDao.delete(dto);
	}


}
