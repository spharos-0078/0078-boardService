package com.pieceofcake.board_service.board.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetNoticeUuidResponseVo {
    private String boardUuid;

    @Builder
    public GetNoticeUuidResponseVo(String boardUuid) {
        this.boardUuid = boardUuid;
    }
}
