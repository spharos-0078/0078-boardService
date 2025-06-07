package com.pieceofcake.board_service.board.application;

import com.pieceofcake.board_service.board.dto.in.CreateBoardRequestDto;
import com.pieceofcake.board_service.board.dto.out.GetBoardResponseDto;
import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.infrastructure.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<GetBoardResponseDto> getBoardList(BoardType boardType) {
        List<Board> boardList = boardRepository.findByBoardType(boardType);
        return boardList.stream().map(GetBoardResponseDto::from).toList();
    }

    // pagable
    // 동적 호출 -> query dsl

    // 게시글 생성
    @Override
    public void createBoard(CreateBoardRequestDto createBoardRequestDto) {
        boardRepository.save(createBoardRequestDto.toEntity());
    }

}
