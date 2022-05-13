package com.springboot.board.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import com.springboot.board.domain.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "BOARD")
public class Board {
    @Id
    @GeneratedValue
    private Long idx;

    @Column(name = "title" , nullable = false)
    private String title;
    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "uploadDate",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "user_idx" , nullable=false) //실제 FK 컬럼명
    @JsonManagedReference
    private User user; // 이 보드가 어떤 사용자에 의해 작성되었는가


    public void setUser(User user){
        if(this.user != null){
            this.user.removeBoard(this);
        }
        this.user = user;
        user.addBoard(this);
    }

    public Long getBoardIdx(){
        return idx;
    }

    public void setUploadDate(Date uploadDate){
        this.uploadDate = uploadDate;
    }

}
