package com.pieceofcake.board_service.board.infrastructure;

import com.pieceofcake.board_service.board.domain.BoardImage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BoardImageRepository extends MongoRepository<BoardImage, String> {
    List<BoardImage> findByBoardUuid(String boardUuid);

    List<BoardImage> findByBoardUuidOrderByBoardImageOrderAsc(String boardUuid);
}
