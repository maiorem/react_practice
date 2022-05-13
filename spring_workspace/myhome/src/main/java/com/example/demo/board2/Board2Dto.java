package com.example.demo.board2;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Board2Dto {
	
	public Board2Dto() {
		super();
	
	}
	public Board2Dto(int id, String title, String contents, String writer) {
		super();
		
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}
	
	private int _id;
	private int id;
	private String title="";
	private String contents="";
	private String writer="";
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
		
		
}
