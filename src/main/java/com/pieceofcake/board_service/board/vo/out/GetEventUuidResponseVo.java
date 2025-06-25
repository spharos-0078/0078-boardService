package com.pieceofcake.board_service.board.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetEventUuidResponseVo {
    private String boardUuid;

    @Builder
    public GetEventUuidResponseVo(String boardUuid) {
        this.boardUuid = boardUuid;
    }
}
