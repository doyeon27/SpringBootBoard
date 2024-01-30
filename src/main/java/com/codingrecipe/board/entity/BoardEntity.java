package com.codingrecipe.board.entity;
// Entity 는 DB의 테이블 역할을 하는 클래스

import com.codingrecipe.board.dto.BoardDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "board_table")
public class BoardEntity extends BaseEntity{

    @Id // pk 컬럼 지정. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(length = 20, nullable = false) // 크기 20, not null
    private String boardWriter;

    @Column // 크기 255, null 가능
    private String boardPass;

    @Column
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;


    // toSaveEntity 는 DTO 를 Entity 로 변환하여 저장할때 사용한다는 의미

    // 사용자가 입력한 데이터를 받아서 DTO 객체에 저장함
    // DTO 객체를 Entity 로 변환해서 DB에 저장하거나 업데이트 함
    public static BoardEntity toSaveEntity(BoardDto boardDto){
        BoardEntity boardEntity = new BoardEntity(); // 이렇게 생성된 객체는 DB에 저장될 하나의 게시물을 나타내는 느낌
        boardEntity.setBoardWriter(boardDto.getBoardWriter());
        boardEntity.setBoardPass(boardDto.getBoardPass());
        boardEntity.setBoardTitle(boardDto.getBoardTitle());
        boardEntity.setBoardContents(boardDto.getBoardContents());
        boardEntity.setBoardHits(0);
        return boardEntity;
    }



}
