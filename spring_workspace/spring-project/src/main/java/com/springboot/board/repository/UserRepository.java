package com.springboot.board.repository;


import com.springboot.board.domain.Board;
import com.springboot.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.BitSet;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long>{
    Optional<User> findById(Long idx);
    <U extends User> U save(U user);
    List<User> findAll();
    void deleteById(Long idx);

    Optional<User> findByuserid(String userid);
}

