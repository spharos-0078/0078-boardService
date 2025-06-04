package com.pieceofcake.board_service.board.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@RestController
public class BoardController {
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from board-service!");
    }
}
