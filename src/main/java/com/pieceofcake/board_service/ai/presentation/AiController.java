package com.pieceofcake.board_service.ai.presentation;

import com.pieceofcake.board_service.ai.application.AiService;
import com.pieceofcake.board_service.ai.application.AiServiceImpl;
import com.pieceofcake.board_service.ai.dto.in.AiRequestDto;
import com.pieceofcake.board_service.ai.dto.out.AiResponseDto;
import com.pieceofcake.board_service.ai.vo.in.AiRequestVo;
import com.pieceofcake.board_service.ai.vo.out.AiResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AiController {
    public final AiService aiService;

    @PostMapping("/price")
    public ResponseEntity<AiResponseVo> selectPrompt(
            @RequestBody AiRequestVo aiRequestVo
    ) {
        AiResponseDto aiResponseDto = aiService.getAnswer(AiRequestDto.from(aiRequestVo));
        AiResponseVo aiResponseVo = aiResponseDto.toVo();
        return new ResponseEntity<>(aiResponseVo, HttpStatus.OK);
    }
}
