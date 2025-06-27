package com.pieceofcake.board_service.board.presentation;

import com.pieceofcake.board_service.board.application.BoardService;
import com.pieceofcake.board_service.board.dto.in.CreateFaqRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateSaleRequestDto;
import com.pieceofcake.board_service.board.vo.in.CreateFaqRequestVo;
import com.pieceofcake.board_service.board.vo.in.CreateSaleRequestVo;
import com.pieceofcake.board_service.common.entity.BaseResponseEntity;
import com.pieceofcake.board_service.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@RestController
public class InquiryBoardController {

    private final BoardService boardService;

    // @GetMapping("/normal/admin") -> 일반 문의 전체 조회 (관리자 인증)
    // @GetMapping("/normal/admin/{boardUuid}") -> 일반 문의 상세 조회 (관리자 인증)

    // @GetMapping("/normal/user") -> 사용자 본인 일반 문의 UUID 리스트 조회
    // @GetMapping("/normal/user/{boardUuid}") -> 사용자 본인 일반 문의 상세 조회


    // @GetMapping("/sale/admin") -> 판매 문의 전체 조회 (관리자 인증)
    // @GetMapping("/sale/admin/{boardUuid}") -> 판매 문의 상세 조회 (관리자 인증)

    // @GetMapping("/sale/user") -> 사용자 본인 판매 문의 UUID 리스트 조회
    // @GetMapping("/sale/user/{boardUuid}") -> 사용자 본인 판매 문의 상세 조회


    // @PostMapping("/sale") -> 판매 문의 생성 (사용자 본인 확인)
    @Operation(summary = "판매 문의 생성")
    @PostMapping("/sale")
    public BaseResponseEntity<Void> createSaleRequest(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody CreateSaleRequestVo createSaleRequestVo
    ) {
        boardService.createSaleRequest(CreateSaleRequestDto.from(memberUuid, createSaleRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    // @PutMapping("/sale/{boardUuid}") -> 판매 문의 수정 (사용자 본인 확인)
    // @DeleteMapping("/sale/{boardUuid}") -> 판매 문의 삭제 (사용자 본인 확인)

    // @PostMapping("/normal") -> 일반 문의 생성 (사용자 본인 확인)
    // @PutMapping("/normal/{boardUuid}") -> 일반 문의 수정 (사용자 본인 확인)
    // @DeleteMapping("/normal/{boardUuid}") -> 일반 문의 삭제 (사용자 본인 확인)

}
