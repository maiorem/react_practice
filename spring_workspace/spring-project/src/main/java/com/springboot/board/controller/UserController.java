package com.springboot.board.controller;


import com.springboot.board.domain.Board;
import com.springboot.board.domain.User;
import com.springboot.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.persistence.JoinColumn;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RequestMapping("/board")
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/ushowAll")
    public String list(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "user/userList";
    }
//
//    @RequestMapping(value ="/ushowOne", method = RequestMethod.GET)
//    public User showOne(@RequestParam (name = "idx") Long idx){
//        return userService.findById(idx);
//    }

    @RequestMapping(value = "/uinsert" , method = RequestMethod.GET)
    public String add(Model model){
        return "user/userReg";
    }

    @RequestMapping(value = "/uinsert",method = RequestMethod.POST)
    public String postAdd(User user){
        userService.saveUser(user);
        return "redirect:/board/ushowAll";
    }

    @RequestMapping(value = "/udelete/{idx}", method = RequestMethod.GET)
    public String del(@PathVariable Long idx){
        userService.deleteById(idx);
        return "redirect:/board/ushowAll";
    }

    @RequestMapping(value = "/uupdate" , method = RequestMethod.POST)
    public void update(@RequestBody User request){userService.saveUser(request);}

}
