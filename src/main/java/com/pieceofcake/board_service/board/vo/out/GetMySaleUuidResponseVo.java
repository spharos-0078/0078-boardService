package com.pieceofcake.board_service.board.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetMySaleUuidResponseVo {
    private String boardUuid;

    @Builder
    public GetMySaleUuidResponseVo(String boardUuid) {
        this.boardUuid = boardUuid;
    }
}
