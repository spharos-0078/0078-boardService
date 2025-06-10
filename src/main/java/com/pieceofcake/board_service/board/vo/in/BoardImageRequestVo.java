package com.pieceofcake.board_service.board.vo.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardImageRequestVo {

    private String boardImageUrl;
    private Integer boardImageOrder;
    private Boolean boardThumbnail;

    @Builder
    public BoardImageRequestVo(
            String boardImageUrl, Integer boardImageOrder, Boolean boardThumbnail
    ) {
        this.boardImageUrl = boardImageUrl;
        this.boardImageOrder = boardImageOrder;
        this.boardThumbnail = boardThumbnail;
    }

}
