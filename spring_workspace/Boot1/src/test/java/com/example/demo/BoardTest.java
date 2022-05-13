package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.BoardDto;
import com.example.demo.repository.BoardRepository;

@SpringBootTest
public class BoardTest {
	@Autowired
    BoardRepository boardRepository;

    @Test
    void save() {
 
        // 1. 게시글 파라미터 생성
        BoardDto params = BoardDto.builder() 
                .title("1번 게시글 제목")
                .contents("1번 게시글 내용")
                .writer("홍길동")
                .hits("0")
                .deleteYn("N")
                .build();

        // 2. 게시글 저장
        boardRepository.save(params);

        // 3. 1번 게시글 정보 조회
        BoardDto entity = boardRepository.findById((long) 1).get();
        assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
        assertThat(entity.getContents()).isEqualTo("1번 게시글 내용");
        assertThat(entity.getWriter()).isEqualTo("홍길동");
    }

    @Test
    void findAll() {

    	Pageable pageable =null;
        // 1. 전체 게시글 수 조회
        long BoardDtoCount = boardRepository.count();

        // 2. 전체 게시글 리스트 조회
        List<BoardDto> list = boardRepository.findAll(pageable).getContent();
    }

    @Test
    void delete() {

        // 1. 게시글 조회
        BoardDto entity = boardRepository.findById((long) 1).get();

        // 2. 게시글 삭제
        boardRepository.delete(entity);
    }
}
