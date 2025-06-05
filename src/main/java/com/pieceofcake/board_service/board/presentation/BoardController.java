package com.pieceofcake.board_service.board.presentation;

import com.pieceofcake.board_service.board.application.BoardService;
import com.pieceofcake.board_service.board.dto.out.GetBoardResponseDto;
import com.pieceofcake.board_service.board.entity.BoardType;
import com.pieceofcake.board_service.board.vo.out.GetBoardResponseVo;
import com.pieceofcake.board_service.common.entity.BaseResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from board-service!");
    }

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
