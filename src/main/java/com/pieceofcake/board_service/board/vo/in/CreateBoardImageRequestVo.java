package com.pieceofcake.board_service.board.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateBoardImageRequestVo {

    private String boardUuid;
    private List<BoardImageRequestVo> boardImageRequestVoList;

    @Builder
    public CreateBoardImageRequestVo(
            String boardUuid, List<BoardImageRequestVo> boardImageRequestVoList
    ) {
        this.boardUuid = boardUuid;
        this.boardImageRequestVoList = boardImageRequestVoList;
    }
}
