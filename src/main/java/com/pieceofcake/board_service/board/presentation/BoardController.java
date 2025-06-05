package com.pieceofcake.board_service.board.presentation;

import com.pieceofcake.board_service.board.application.BoardService;
import com.pieceofcake.board_service.board.dto.out.GetBoardResponseDto;
import com.pieceofcake.board_service.board.entity.BoardType;
import com.pieceofcake.board_service.board.vo.out.GetBoardResponseVo;
import com.pieceofcake.board_service.common.entity.BaseResponseEntity;
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

    // 공지사항, FAQ, 이벤트, 일반 문의 각각 게시판 전체조회
    @Operation(summary = "게시판 전체 조회")
    @GetMapping("/list/{boardType}")
    public BaseResponseEntity<List<GetBoardResponseVo>> getBoardList(
            @PathVariable("boardType") BoardType boardType
            ) {
        List<GetBoardResponseVo> result = boardService.getBoardList(boardType)
                .stream().map(GetBoardResponseDto::toVo).toList();
        return new BaseResponseEntity<>(result);
    }

}
