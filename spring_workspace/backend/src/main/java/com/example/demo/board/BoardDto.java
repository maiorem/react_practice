package com.example.demo.board;

public class BoardDto {
	private int id;
	private String title="";
	private String contents="";
	private String writer="";
	
	@Override
	public boolean equals(Object obj) {
		BoardDto temp = (BoardDto)obj;
		if (this.id == temp.id)
			return true;
		else
			return false;
	}
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(int id, String title, String contents, String writer) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
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
