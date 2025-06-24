package com.pieceofcake.board_service.board.presentation;

import com.pieceofcake.board_service.board.application.BoardService;
import com.pieceofcake.board_service.board.dto.in.CreateBoardRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateCommunityRequestDto;
import com.pieceofcake.board_service.board.dto.out.GetBoardResponseDto;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.vo.in.CreateBoardRequestVo;
import com.pieceofcake.board_service.board.vo.in.CreateCommunityRequestVo;
import com.pieceofcake.board_service.board.vo.in.CreateSaleRequestVo;
import com.pieceofcake.board_service.board.vo.out.GetBoardResponseVo;
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

//    // 공지사항, FAQ, 이벤트 게시판 전체조회
//    // 페이지네이션 적용할 것
//    @Operation(summary = "게시판 타입별 전체 조회")
//    @GetMapping("/list/{boardType}")
//    public BaseResponseEntity<List<GetBoardResponseVo>> getBoardList(
//            @PathVariable("boardType") BoardType boardType
//    ) {
//        List<GetBoardResponseVo> result = boardService.getBoardList(boardType)
//                .stream().map(GetBoardResponseDto::toVo).toList();
//        return new BaseResponseEntity<>(result);
//    }
//
//    @Operation(summary = "게시글 생성")
//    @PostMapping
//    public BaseResponseEntity<Void> createBoard(
//            @RequestHeader("X-Member-Uuid") String memberUuid,
//            @RequestBody CreateBoardRequestVo createBoardRequestVo
//    ) {
//        boardService.createBoard(CreateBoardRequestDto.from(memberUuid, createBoardRequestVo));
//        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
//    }

    // @GetMapping("/notice") -> 공지사항 전체 조회 (아무나)

    // @GetMapping("/notice/{boardUuid}") -> 공지사항 단건 조회 (아무나)

    // @GetMapping("/event") -> 이벤트 전체 조회 (아무나)

    // @GetMapping("/event/{boardUuid}") -> 이벤트 단건 조회 (아무나)

    // @GetMapping("/faq") -> FAQ 전체 조회 (아무나)

    // @GetMapping("/faq/{boardUuid}") -> FAQ 단건 조회 (아무나)

    // @PostMapping("/{boardType}") -> 공지사항/이벤트/FAQ 작성 (관리자 인증)

    // @PutMapping("/{boardType}/{boardUuid}") -> 공지사항/이벤트/FAQ 수정 (관리자 인증)

    // @DeleteMapping("/{boardType}/{boardUuid}") -> 공지사항/이벤트/FAQ 수정 (관리자 인증)

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
