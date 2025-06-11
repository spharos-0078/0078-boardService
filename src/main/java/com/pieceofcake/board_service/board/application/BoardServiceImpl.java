package com.pieceofcake.board_service.board.application;

import com.pieceofcake.board_service.board.domain.BoardImage;
import com.pieceofcake.board_service.board.dto.in.CreateBoardImageRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateBoardRequestDto;
import com.pieceofcake.board_service.board.dto.out.GetBoardResponseDto;
import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.infrastructure.BoardImageRepository;
import com.pieceofcake.board_service.board.infrastructure.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BoardImageRepository boardImageRepository;

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
        String boardUuid = UUID.randomUUID().toString().substring(0, 32);
        Board board = boardRepository.save(createBoardRequestDto.toEntity(boardUuid));

        List<BoardImage> boardImageList = boardImageRepository.saveAll(
                CreateBoardImageRequestDto.of(boardUuid, createBoardRequestDto.getBoardImageRequestDtoList())
                        .getBoardImageRequestDtoList()
                        .stream().map(i -> i.toEntity(boardUuid))
                        .toList()
        );
    }
}
