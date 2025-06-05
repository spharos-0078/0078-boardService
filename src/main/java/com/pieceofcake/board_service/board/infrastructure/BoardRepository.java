package com.pieceofcake.board_service.board.infrastructure;

import com.pieceofcake.board_service.board.entity.Board;
import com.pieceofcake.board_service.board.entity.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByBoardType(BoardType boardType);

}
