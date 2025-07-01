package com.pieceofcake.board_service.board.infrastructure;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends MongoRepository<Board, String> {

    boolean existsByBoardTypeAndBoardUuidAndDeletedFalse(BoardType boardType, String boardUuid);

    List<Board> findByBoardTypeAndDeletedFalse(BoardType boardType);

    Optional<Board> findByBoardUuidAndBoardTypeAndDeletedFalse(String boardUuid, BoardType boardType);

    List<Board> findByBoardTypeAndMemberUuidAndDeletedFalse(BoardType boardType, String memberUuid);

    Optional<Board> findByBoardUuidAndMemberUuidAndDeletedFalse(String boardUuid, String memberUuid);
}
