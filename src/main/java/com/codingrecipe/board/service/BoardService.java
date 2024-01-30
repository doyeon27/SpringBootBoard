package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDto;
import com.codingrecipe.board.entity.BoardEntity;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// DTO -> Entity 로 변환하거나 (Entity Class)
// Entity -> DTO 로 변환하거나 하는 일을 함 (DTO Class)
@Service
@RequiredArgsConstructor
public class BoardService  {

    @Autowired
    BoardRepository boardRepository;
    public void save(BoardDto boardDto) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDto);
        boardRepository.save(boardEntity); // <- save() 에는 Entity 클래스 객체를 넘겨줘야함
    }
}
