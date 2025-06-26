package com.pieceofcake.board_service.board.vo.in;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateNoticeRequestVo {

    private String boardTitle;
    private String boardContent;
    private List<BoardImageRequestVo> boardImageRequestVoList;

    @Builder
    public CreateNoticeRequestVo(
            String boardTitle, String boardContent, List<BoardImageRequestVo> boardImageRequestVoList
    ) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardImageRequestVoList = boardImageRequestVoList;
    }
}
