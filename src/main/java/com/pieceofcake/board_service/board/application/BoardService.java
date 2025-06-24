package com.pieceofcake.board_service.board.application;

import com.pieceofcake.board_service.board.dto.in.CreateBoardRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateCommunityRequestDto;
import com.pieceofcake.board_service.board.dto.out.GetBoardResponseDto;
import com.pieceofcake.board_service.board.domain.BoardType;

import java.util.List;

public interface BoardService {
//    List<GetBoardResponseDto> getBoardList(BoardType boardType);
//
//    void createBoard(CreateBoardRequestDto createBoardRequestDto);

    void createCommunityBoard(CreateCommunityRequestDto createCommunityRequestDto);
}
