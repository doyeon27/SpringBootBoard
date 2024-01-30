package com.codingrecipe.board.repository;

import com.codingrecipe.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository<BoardEntity, Long> -> 전달인자 2개는 Entity 클래스와, 그 클래스가 가지고 있는 PK의 타입
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
