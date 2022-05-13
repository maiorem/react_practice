package com.springboot.board.service;

import com.springboot.board.domain.Board;
import com.springboot.board.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.Oneway;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private BoardService boardService;

    private User user;
    private Board board;

    //testclass 메서드들이 테스트되기 전에 실행되도록 지정하는 annotation
    @Before
    public void setup(){
        user = new User();
        board = new Board();

        user.setUserid("npay");
        user.setUsername("kimyumin");
        user.setPhoneNum("010-1234-5678");


        board.setTitle("test");
        board.setContent("content test");
        Date d = new Date();
        board.setUploadDate(d);

        board.setUser(user);
        user.addBoard(board);

    }

    @Test
    public void findAll(){
        assertThat(userService.findAll().size()).isNotNull();
        assertThat(boardService.findAll().size()).isNotNull();
    }

    @Test
    public void insert(){
        userService.saveUser(user);
        boardService.saveBoard(board);
        assertThat((board.getUser()).getUsername()).isEqualTo("kimyumin");
    }

    @Test
    public void getOne(){
        assertThat(userService.findById(7L).getUseridx()).isEqualTo(7L);
        assertThat(boardService.findById(79L).getBoardIdx()).isEqualTo(79L);

    }

    @Test
    public void update(){
        User updateuser = userService.findById(7L);
        updateuser.setUsername("update");
        userService.saveUser(updateuser);
        assertThat(userService.findById(updateuser.getUseridx()).getUsername()).isEqualTo("update");

        Board updateboard = boardService.findById(79L);
        updateboard.setContent("update content");
        updateboard.setTitle("update title");
        boardService.saveBoard(updateboard);
        assertThat(boardService.findById(updateboard.getBoardIdx()).getTitle()).isEqualTo("update title");
        assertThat(boardService.findById(updateboard.getBoardIdx()).getContent()).isEqualTo("update content");

    }

    @Test(expected = NoSuchElementException.class)
    public void deleteOne() {
        // 하나의 데이터 삭제
        userService.deleteById(7L);
        assertThat(userService.findById(7L)).isNull();

        boardService.deleteById(79L);
        assertThat(boardService.findById(79L)).isNull();
    }
}

