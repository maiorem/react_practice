package com.springboot.board.controller;


import com.springboot.board.domain.User;
import com.springboot.board.service.BoardService;
import com.springboot.board.domain.Board;
import com.springboot.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RequestMapping("/board")
@Controller
public class BoardController {
    private final BoardService boardService;
    private final UserService userService;

    @Autowired
    public BoardController(BoardService boardService, UserService userService) {
        this.boardService = boardService;
        this.userService = userService;
    }

    @RequestMapping(value = "/bshowAll", method = RequestMethod.GET)
    public String list(Model model) {
        List<Board> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }

    @RequestMapping(value = "/bshowOne/{idx}", method = RequestMethod.GET)
    public String showOne(@PathVariable Long idx, Model model) {
        Board boardList = boardService.findById(idx);
        model.addAttribute("boardList", boardList);
        return "board/boardDetail";
    }


    @RequestMapping(value = "/binsert", method = RequestMethod.GET)
    public String add(Model model) {
        return "board/boardReg";
    }

    @RequestMapping(value = "/binsert", method = RequestMethod.POST)
    public String addPost(@RequestParam("userid") String userid, Board board) {
        Date date = new Date();
        board.setUploadDate(date);
        board.setUser(userService.findByuserid(userid));

        boardService.saveBoard(board);
        return "redirect:/board/bshowAll";
    }

    @RequestMapping(value = "/bupdate/{idx}", method = RequestMethod.GET)
    public String update(@PathVariable Long idx, Model model) {
        Board board = boardService.findById(idx);
        model.addAttribute("data", board);
        return "board/boardMod";
    }

    @RequestMapping(value = "/bupdate", method = RequestMethod.POST)
    public String postUpdate(@RequestParam("userid") String userid, Board board) {
        Date newdate = new Date();
        board.setUploadDate(newdate);
        board.setUser(userService.findByuserid(userid));

        boardService.saveBoard(board);

        return "redirect:/board/bshowAll";
    }


    @RequestMapping(value = "/bdelete/{idx}", method = RequestMethod.GET)
    public String dele(@PathVariable Long idx) {
        boardService.deleteById(idx);
        return "redirect:/board/bshowAll";
    }

}
