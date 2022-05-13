package com.example.demo.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired 
	BoardDao dao;
	
	List<BoardDto> getList(){
		return dao.getList();
	}
}
