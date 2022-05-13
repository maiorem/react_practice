package com.woori.hello.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.Builder;
   
@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)  //기본생성자를 만들어준다 
public class BoardDto {
	    
	private long id=-1;
	private String title="";
	private String writer="";
	private String contents="";
	private String wdate="";
	private int hit=0;
	
	@Builder
	public BoardDto(long id, String title, String writer, String contents, String wdate) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.wdate = wdate;
	}
	
	
}
