package com.codingrecipe.board.repository;

import com.codingrecipe.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


// JpaRepository<BoardEntity, Long> -> 전달인자 2개는 Entity 클래스와, 그 클래스가 가지고 있는 PK의 타입
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // 조회수 증가
    // update board_table set board_hits=board_hits+1 where id=?

    // BoardEntity 은 DB 테이블이 아니라 Entity 기준으로 쓰고 b 이런거 필수로 적어야함
    // boardHits DB 컬럼이 아니라 엔티티에 정의된 컬럼임
    @Modifying // update 나 delete 같은 쿼리를 실행해야 할때는 이 어노테이션을 필수로 붙여야 함
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id")
    void  updateHits(@Param("id") Long id);
}
