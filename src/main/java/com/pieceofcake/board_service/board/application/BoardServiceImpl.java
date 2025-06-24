package com.pieceofcake.board_service.board.application;

import com.pieceofcake.board_service.board.domain.BoardImage;
import com.pieceofcake.board_service.board.dto.in.CreateBoardImageRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateBoardRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateCommunityRequestDto;
import com.pieceofcake.board_service.board.dto.out.GetBoardResponseDto;
import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.infrastructure.BoardImageRepository;
import com.pieceofcake.board_service.board.infrastructure.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BoardImageRepository boardImageRepository;

//    @Override
//    public List<GetBoardResponseDto> getBoardList(BoardType boardType) {
//        List<Board> boardList = boardRepository.findByBoardType(boardType);
//        return boardList.stream().map(GetBoardResponseDto::from).toList();
//    }
//
//    // pagable
//    // 동적 호출 -> query dsl
//
//    // 게시글 생성
//    @Override
//    public void createBoard(CreateBoardRequestDto createBoardRequestDto) {
//        String boardUuid = UUID.randomUUID().toString().substring(0, 32);
//        Board board = boardRepository.save(createBoardRequestDto.toEntity(boardUuid));
//
//        List<BoardImage> boardImageList = boardImageRepository.saveAll(
//                CreateBoardImageRequestDto.of(boardUuid, createBoardRequestDto.getBoardImageRequestDtoList())
//                        .getBoardImageRequestDtoList()
//                        .stream().map(i -> i.toEntity(boardUuid))
//                        .toList()
//        );
//    }

    @Override
    public void createCommunityBoard(CreateCommunityRequestDto createCommunityRequestDto) {
        boolean exists = boardRepository.existsByBoardTypeAndBoardUuidAndDeletedFalse(createCommunityRequestDto.getBoardType(), createCommunityRequestDto.getBoardUuid());
        if (exists) {
            throw new IllegalArgumentException("이미 해당 커뮤니티 게시판이 존재합니다.");
        }

        Board board = Board.builder()
                .boardType(createCommunityRequestDto.getBoardType())
                .boardUuid(createCommunityRequestDto.getBoardUuid())
                .build();

        boardRepository.save(board);
    }
}
