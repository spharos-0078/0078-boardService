package com.pieceofcake.board_service.board.presentation;

import com.pieceofcake.board_service.board.application.BoardService;
import com.pieceofcake.board_service.board.dto.in.CreateCommunityRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateEventRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateFaqRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateNoticeRequestDto;
import com.pieceofcake.board_service.board.dto.out.*;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.vo.in.CreateCommunityRequestVo;
import com.pieceofcake.board_service.board.vo.in.CreateEventRequestVo;
import com.pieceofcake.board_service.board.vo.in.CreateFaqRequestVo;
import com.pieceofcake.board_service.board.vo.in.CreateNoticeRequestVo;
import com.pieceofcake.board_service.board.vo.out.*;
import com.pieceofcake.board_service.common.entity.BaseResponseEntity;
import com.pieceofcake.board_service.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // Test API
    @Operation(summary = "조회 테스트 API")
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from board-service!");
    }

    @Operation(summary = "공지사항 UUID 리스트 조회")
    @GetMapping("/notice")
    public BaseResponseEntity<List<GetNoticeUuidResponseVo>> getNoticeBoardUuidList() {
        List<GetNoticeUuidResponseVo> noticeList = boardService.getNoticeBoardUuidListByBoardType(BoardType.REPORT)
                .stream().map(GetNoticeUuidResponseDto::toVo).toList();

        return new BaseResponseEntity<>(noticeList);
    }

    @Operation(summary = "공지사항 상세 조회")
    @GetMapping("/notice/{boardUuid}")
    public BaseResponseEntity<GetNoticeResponseVo> getNoticeDetail(@PathVariable String boardUuid) {
        return new BaseResponseEntity<>(boardService.getNoticeBoardByBoardUuid(boardUuid).toVo());}

    @Operation(summary = "이벤트 UUID 리스트 조회")
    @GetMapping("/event")
    public BaseResponseEntity<List<GetEventUuidResponseVo>> getEventBoardUuidList() {
        List<GetEventUuidResponseVo> eventList = boardService.getEventBoardUuidListByBoardType(BoardType.EVENT)
                .stream().map(GetEventUuidResponseDto::toVo).toList();

        return new BaseResponseEntity<>(eventList);
    }

    @Operation(summary = "이벤트 상세 조회")
    @GetMapping("/event/{boardUuid}")
    public BaseResponseEntity<GetEventResponseVo> getEventDetail(@PathVariable String boardUuid) {
        return new BaseResponseEntity<>(boardService.getEventBoardByBoardUuid(boardUuid).toVo());
    }

    @Operation(summary = "FAQ UUID 리스트 조회")
    @GetMapping("/faq")
    public BaseResponseEntity<List<GetFaqUuidResponseVo>> getFaqBoardUuidList() {
        List<GetFaqUuidResponseVo> faqList = boardService.getFaqBoardUuidListByBoardType(BoardType.FAQ)
                .stream().map(GetFaqUuidResponseDto::toVo).toList();

        return new BaseResponseEntity<>(faqList);
    }

    @Operation(summary = "FAQ 상세 조회")
    @GetMapping("/faq/{boardUuid}")
    public BaseResponseEntity<GetFaqResponseVo> getFaqDetail(@PathVariable String boardUuid) {
        return new BaseResponseEntity<>(boardService.getFaqBoardByBoardUuid(boardUuid).toVo());
    }

    // @PostMapping("/notice") -> 공지사항 생성
    @Operation(summary = "공지사항 생성")
    @PostMapping("/notice")
    public BaseResponseEntity<Void> createNotice(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody CreateNoticeRequestVo createNoticeRequestVo
    ) {
        boardService.createNotice(CreateNoticeRequestDto.from(memberUuid, createNoticeRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    // @PutMapping("/notice/{boardUuid}") -> 공지사항 수정

    // @DeleteMapping("/notice/{boardUuid}") -> 공지사항 삭제

    // @PostMapping("/event") -> 이벤트 게시판 생성
    @Operation(summary = "이벤트 생성")
    @PostMapping("/event")
    public BaseResponseEntity<Void> createEvent(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody CreateEventRequestVo createEventRequestVo
    ) {
        boardService.createEvent(CreateEventRequestDto.from(memberUuid, createEventRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    // @PutMapping("/event/{boardUuid}") -> 이벤트 수정

    // @DeleteMapping("/event/{boardUuid}") -> 이벤트 삭제

    // @PostMapping("/faq") -> FAQ 생성
    @Operation(summary = "FAQ 생성")
    @PostMapping("/faq")
    public BaseResponseEntity<Void> createFaq(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody CreateFaqRequestVo createFaqRequestVo
    ) {
        boardService.createFaq(CreateFaqRequestDto.from(memberUuid, createFaqRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    // @PutMapping("/faq/{boardUuid}") -> FAQ 수정

    // @DeleteMapping("/faq/{boardUuid}") -> FAQ 삭제


    // @PostMapping("/community") -> 공모/조각 커뮤니티 게시판 생성
    @Operation(summary = "공모/조각 커뮤니티 게시판 생성")
    @PostMapping("/community")
    public BaseResponseEntity<Void> createCommunityBoard(
            @RequestBody CreateCommunityRequestVo createCommunityRequestVo
    ) {
        boardService.createCommunityBoard(CreateCommunityRequestDto.from(createCommunityRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
