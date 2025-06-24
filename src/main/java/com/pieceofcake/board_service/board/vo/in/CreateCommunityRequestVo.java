package com.pieceofcake.board_service.board.vo.in;

import com.pieceofcake.board_service.board.domain.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateCommunityRequestVo {

    private BoardType boardType;
    private String boardUuid;

    @Builder
    public CreateCommunityRequestVo(BoardType boardType, String boardUuid) {
        this.boardType = boardType;
        this.boardUuid = boardUuid;
    }
}
