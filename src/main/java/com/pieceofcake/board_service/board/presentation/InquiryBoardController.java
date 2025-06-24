package com.pieceofcake.board_service.board.presentation;

import com.pieceofcake.board_service.board.application.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/inquiries")
@RequiredArgsConstructor
@RestController
public class InquiryBoardController {

    private final BoardService boardService;

    // @GetMapping("/normal") -> 일반 문의 전체 조회 (관리자 / 작성자 인증)

    // @GetMapping("/normal/{boardUuid}") -> 일반 문의 상세 조회 (관리자 / 작성자 인증)

    // @GetMapping("/sale") -> 판매 문의 전체 조회 (관리자 / 작성자 인증)

    // @GetMapping("/sale/{boardUuid}") -> 판매 문의 상세 조회 (관리자 / 작성자 인증)

    // @PostMapping("/sale") -> 판매 문의 생성 (본인 확인)

    // @PutMapping("/sale/{boardUuid}") -> 판매 문의 수정 (본인 확인)

    // @DeleteMapping("/sale/{boardUuid}") -> 판매 문의 삭제 (본인 확인)

    // @PostMapping("/normal") -> 일반 문의 생성 (본인 확인)

    // @PutMapping("/normal/{boardUuid}") -> 일반 문의 수정 (본인 확인)

    // @DeleteMapping("/normal/{boardUuid}") -> 일반 문의 삭제 (본인 확인)

}
