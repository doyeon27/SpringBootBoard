package com.codingrecipe.board.dto;

import lombok.*;

import java.time.LocalDateTime;

// DTO(Data Transfer Object) = 데이터를 전송할때 사용하는 객체
// Vo, ~~ Bean 비슷함

@Getter
@Setter
@ToString // 필드값 확인할 때 주로 사용
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class BoardDto {

    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdateTime;
}
