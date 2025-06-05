package com.pieceofcake.board_service.board.application;

import com.pieceofcake.board_service.board.dto.out.GetBoardResponseDto;
import com.pieceofcake.board_service.board.entity.BoardType;

import java.util.List;

public interface BoardService {
    List<GetBoardResponseDto> getBoardList(BoardType boardType);
}
