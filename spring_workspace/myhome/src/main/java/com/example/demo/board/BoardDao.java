
package com.example.demo.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.common.SequenceGenerator;

@Component("boardDao")
public class BoardDao {
	@Autowired 
	MongoTemplate mt;
	
	public List<BoardDto> getList()
	{
		BoardDto dto = new BoardDto();
		List<BoardDto> list = mt.findAll(BoardDto.class);
		
		return list;
	}
	
	public void delete(String id)
	{
		//삭제조건 - Criteria 
		Criteria criteria = new Criteria("_id");
		criteria.is(id);
		
		Query query = new Query(criteria);
		
		mt.remove(query, "guestbook");
		
	}
	
	public void insert(BoardDto dto) {
		int seq = SequenceGenerator.generateSequence(mt, "board");
		dto.setId(seq);
		
		mt.insert(dto); //title, writer, contents 는 이미 있음 
 	}
	
	
	public BoardDto getView(String _id)
	{
		Criteria criteria = new Criteria("_id");
		criteria.is(_id);
		
		Query query = new Query(criteria);
		
		BoardDto dto = mt.findOne(query, BoardDto.class, "guestbook");
		
		return dto;
	}
	
	public void update(BoardDto dto) {
	
		mt.save(dto);  
 	}
	
}





