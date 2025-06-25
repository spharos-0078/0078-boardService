package com.pieceofcake.board_service.board.application;

import com.pieceofcake.board_service.board.domain.BoardImage;
import com.pieceofcake.board_service.board.dto.in.CreateBoardImageRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateBoardRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateCommunityRequestDto;
import com.pieceofcake.board_service.board.dto.out.*;
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

    // 공지사항 UUID 리스트 조회
    @Override
    public List<GetNoticeUuidResponseDto> getNoticeBoardUuidListByBoardType(BoardType boardType) {
        List<Board> noticeList = boardRepository.findByBoardTypeAndDeletedFalse(boardType);
        return noticeList.stream().map(GetNoticeUuidResponseDto::from).toList();
    }

    // 공지사항 상세 조회
    @Override
    public GetNoticeResponseDto getNoticeBoardByBoardUuid(String boardUuid) {
        Board board = boardRepository.findByBoardUuidAndBoardTypeAndDeletedFalse(boardUuid, BoardType.REPORT)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공지사항입니다."));

        List<BoardImage> boardImages = boardImageRepository.findByBoardUuidOrderByBoardImageOrderAsc(boardUuid);

        return GetNoticeResponseDto.from(board, boardImages);
    }

    // 이벤트 UUID 리스트 조회
    @Override
    public List<GetEventUuidResponseDto> getEventBoardUuidListByBoardType(BoardType boardType) {
        List<Board> eventList = boardRepository.findByBoardTypeAndDeletedFalse(boardType);
        return eventList.stream().map(GetEventUuidResponseDto::from).toList();
    }

    // 이벤트 상세 조회
    @Override
    public GetEventResponseDto getEventBoardByBoardUuid(String boardUuid) {
        Board board = boardRepository.findByBoardUuidAndBoardTypeAndDeletedFalse(boardUuid, BoardType.EVENT)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이벤트입니다."));
        List<BoardImage> boardImages = boardImageRepository.findByBoardUuidOrderByBoardImageOrderAsc(boardUuid);
        return GetEventResponseDto.from(board, boardImages);
    }

    // Faq UUID 리스트 조회
    @Override
    public List<GetFaqUuidResponseDto> getFaqBoardUuidListByBoardType(BoardType boardType) {
        List<Board> faqList = boardRepository.findByBoardTypeAndDeletedFalse(boardType);
        return faqList.stream().map(GetFaqUuidResponseDto::from).toList();
    }

    // FAQ 상세 조회
    @Override
    public GetFaqResponseDto getFaqBoardByBoardUuid(String boardUuid) {
        Board board = boardRepository.findByBoardUuidAndBoardTypeAndDeletedFalse(boardUuid, BoardType.FAQ)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 FAQ입니다."));
        List<BoardImage> boardImages = boardImageRepository.findByBoardUuidOrderByBoardImageOrderAsc(boardUuid);
        return GetFaqResponseDto.from(board, boardImages);
    }

    // 커뮤니티 게시판 생성
    @Override
    public void createCommunityBoard(CreateCommunityRequestDto createCommunityRequestDto) {
        boolean exists = boardRepository.existsByBoardTypeAndBoardUuidAndDeletedFalse(
                createCommunityRequestDto.getBoardType(), createCommunityRequestDto.getBoardUuid());
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
