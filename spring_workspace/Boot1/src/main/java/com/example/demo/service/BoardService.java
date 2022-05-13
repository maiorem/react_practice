package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.BoardDto;
import com.example.demo.repository.BoardRepository;


//https://www.baeldung.com/spring-jpa-like-queries
	
	
@Service
@Transactional
public class BoardService {
	@Autowired
	private BoardRepository repository;
		  
	public List<BoardDto> getList( BoardDto board, Pageable pageable){		  
		
		//Sort sort =  new Sort(Sort.Direction.ASC, "id");
		//return repository.findAll(pageable).getContent();
//		if( board.getTitle() == null)
//			return repository.findByOrderByIdDesc(pageable);
//		else
//			return repository.findByTitleOrderByIdDesc(board.getTitle(), pageable);
//		
		//return repository.findByTitleLike("%"+board.getTitle()+"%", pageable);
		
		return repository.searchByTitleLike(board.getTitle(), board.getContents());
	}
	  
	public int GetCount() {		  
		return (int) repository.count();
	}
	  
	@Transactional
	public void write(BoardDto dto) {
	     repository.save(dto);
	}
	
	
	public void update(BoardDto dto) {
	     repository.save(dto);
	}
	
	
	public void delete(BoardDto dto) {
		 //BoardDto	dto = repository.findById(id).get();
	     repository.delete(dto);
	}
	
	  
}
