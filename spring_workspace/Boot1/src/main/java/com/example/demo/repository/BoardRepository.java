package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/*
create table board_dto (
	    id bigint not null auto_increment comment 'PK',
	    title varchar(100) not null comment '제목',
	    content text not null comment '내용',
	    writer varchar(20) not null comment '작성자',
	    hits int not null comment '조회 수',
	    delete_yn enum('Y', 'N') not null comment '삭제 여부',
	    created_date datetime not null comment '생성일',
	    modified_date datetime comment '수정일',
	    primary key (id)
	) comment '게시판';
*/

//https://congsong.tistory.com/51
//https://waspro.tistory.com/636
	
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.BoardDto;


public interface BoardRepository extends JpaRepository<BoardDto, Long>{

	
	 //findByOrderBySeatNumberAsc
	
	 List<BoardDto> findByTitleOrderByIdDesc(String title,  Pageable pageable);
	 List<BoardDto> findByOrderByIdDesc(Pageable pageable);
	 List<BoardDto> findByTitleLike(String title, Pageable pageable);
	 
	 //쿼리작성시 실제 테이블명을 사용하는게 아니라 도메인 이름을 써야 한다 
	 @Query("SELECT m FROM BoardDto as m WHERE m.title LIKE %:title% or m.contents like %:contents%")
	 List<BoardDto> searchByTitleLike(@Param("title") String title, @Param("contents") String contents);
	 
	 
	 
	 //List<BoardDto> findByTitleContentsLike(String title, Pageable pageable);
    //Page<Board> findAllByAccount(Pageable pageable, String account);
    // 2. 상태 조건 find
   // Page<User> findAllByStatus(Pageable pageable, UserStatus status);
    // 3. 계정, 상태 조건 find
   // Page<User> findAllByAccountAndStatus(Pageable pageable, String account, UserStatus status);
    // 4. Specification를 이용하여 동적으로 조건을 세팅하여 find
   // Page<User> findAll(Specification<User> spec, Pageable pageable);
    
}
