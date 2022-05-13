package com.example.demo.board;

public class BoardDto {
	private int id=0;
	private String title="";
	private String contents="";
	private String writer="";
	private String wdate="";
	
	
	public BoardDto(int id, String title, String contents, String writer, String wdate) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.wdate = wdate;
	}
	
	
	public BoardDto() {
		super();
	
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
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	
}
