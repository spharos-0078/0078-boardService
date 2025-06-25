package com.pieceofcake.board_service.board.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetFaqUuidResponseVo {
    private String boardUuid;

    @Builder
    public GetFaqUuidResponseVo(String boardUuid) {
        this.boardUuid = boardUuid;
    }
}
