package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDto;
import com.codingrecipe.board.entity.BoardEntity;
import com.codingrecipe.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

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


    @Transactional
    public List<BoardDto> findAll() {
        // repository 메소드인 findAll 을 하게 되면 거의 대부분 Entity 로 가져 옴
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        for(BoardEntity boardEntity : boardEntityList){
            boardDtoList.add(BoardDto.toBoardDTO(boardEntity));
        }
        return boardDtoList;
    }
}
