package com.springboot.board.repository;


import com.springboot.board.domain.Board;
import com.springboot.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board , Long>{
    List<Board> findAll();
    Optional <Board> findById(Long idx);
    <B extends Board> B save(B board);
    void deleteById(Long index);

}

