package com.springboot.board.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import com.springboot.board.domain.Board;


import com.springboot.board.domain.User;
import com.springboot.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(Long idx){
        return userRepository.findById(idx).get();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteById(Long idx) {
        userRepository.deleteById(idx);
    }

    public User findByuserid(String userid){
        return userRepository.findByuserid(userid).get();
    }


}
