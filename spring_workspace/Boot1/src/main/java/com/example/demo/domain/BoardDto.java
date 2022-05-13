package com.example.demo.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Data
@Table(name = "TB_BOARD")
public class BoardDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK
    private String title; // 제목
    private String contents; // 내용
    private String writer; // 작성자
    private String hits; // 조회 수
    private String deleteYn; // 삭제 여부
    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일
    private LocalDateTime modifiedDate; // 수정일

    @Builder
    public BoardDto(String title, String contents, String writer, String hits, String deleteYn) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.hits = hits;
        this.deleteYn = deleteYn;
    }
}