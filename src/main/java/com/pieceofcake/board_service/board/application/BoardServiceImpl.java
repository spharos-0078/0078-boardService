package com.pieceofcake.board_service.board.application;

import com.pieceofcake.board_service.ai.application.AiService;
import com.pieceofcake.board_service.ai.dto.in.AiRequestDto;
import com.pieceofcake.board_service.ai.dto.out.AiResponseDto;
import com.pieceofcake.board_service.board.domain.BoardImage;
import com.pieceofcake.board_service.board.dto.in.*;
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
    private final AiService aiService;

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

    // 공지사항 생성
    @Override
    public void createNotice(CreateNoticeRequestDto createNoticeRequestDto) {
        Board board = createNoticeRequestDto.toEntity();
        boardRepository.save(board);

        List<BoardImage> boardImages = createNoticeRequestDto.getBoardImageRequestDtoList().stream()
                .map(img -> img.toEntity(createNoticeRequestDto.getBoardUuid()))
                .toList();

        boardImageRepository.saveAll(boardImages);
    }

    // 이벤트 생성
    @Override
    public void createEvent(CreateEventRequestDto createEventRequestDto) {
        Board board = createEventRequestDto.toEntity();
        boardRepository.save(board);

        List<BoardImage> boardImages = createEventRequestDto.getBoardImageRequestDtoList().stream()
                .map(img -> img.toEntity(createEventRequestDto.getBoardUuid()))
                .toList();

        boardImageRepository.saveAll(boardImages);

    }

    // FAQ 생성
    @Override
    public void createFaq(CreateFaqRequestDto createFaqRequestDto) {
        Board board = createFaqRequestDto.toEntity();
        boardRepository.save(board);

        List<BoardImage> boardImages = createFaqRequestDto.getBoardImageRequestDtoList().stream()
                .map(img -> img.toEntity(createFaqRequestDto.getBoardUuid()))
                .toList();

        boardImageRepository.saveAll(boardImages);
    }

    // 판매 문의 생성
    @Override
    public void createSaleRequest(CreateSaleRequestDto createSaleRequestDto) {
        String boardUuid = UUID.randomUUID().toString().substring(0, 32);

        // 이미지 최대 3개까지만 전달
        List<String> imageUrls = createSaleRequestDto.getBoardImageRequestDtoList().stream()
                .limit(3)
                .map(BoardImageRequestDto::getBoardImageUrl)
                .toList();

        // AI 호출
        String joinedImageUrls = String.join(",", imageUrls);
        AiRequestDto aiRequestDto = AiRequestDto.of(createSaleRequestDto.getBoardTitle(), joinedImageUrls);
        AiResponseDto aiResponseDto = aiService.getAnswer(aiRequestDto);

        Long aiEstimatedPrice = aiResponseDto.getEstimatedPrice(); // "11500000"
        String aiEstimatedDescription = aiResponseDto.getDescription(); // 설명

        // 게시글 저장
        Board board = boardRepository.save(createSaleRequestDto.toEntity(boardUuid, aiEstimatedPrice, aiEstimatedDescription));

        // 이미지 저장
        List<BoardImage> imageEntities = boardImageRepository.saveAll(
                createSaleRequestDto.getBoardImageRequestDtoList().stream()
                        .map(imgDto -> imgDto.toEntity(boardUuid))
                        .toList()
        );
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
