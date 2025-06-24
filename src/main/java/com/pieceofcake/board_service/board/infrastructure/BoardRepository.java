package com.pieceofcake.board_service.board.infrastructure;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends MongoRepository<Board, String> {

//    List<Board> findByBoardType(BoardType boardType);
//
//    List<Board> findByMemberUuid(String memberUuid);

    boolean existsByBoardTypeAndBoardUuidAndDeletedFalse(BoardType boardType, String boardUuid);

}
