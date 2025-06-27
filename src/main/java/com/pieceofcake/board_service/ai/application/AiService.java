package com.pieceofcake.board_service.ai.application;

import com.pieceofcake.board_service.ai.dto.in.AiRequestDto;
import com.pieceofcake.board_service.ai.dto.out.AiResponseDto;

import java.util.Map;

public interface AiService {
    Map<String, Object> modelList();

    AiResponseDto getAnswer(AiRequestDto aiRequestDto);
}
