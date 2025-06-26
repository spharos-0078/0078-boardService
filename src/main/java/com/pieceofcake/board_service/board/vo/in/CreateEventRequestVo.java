package com.pieceofcake.board_service.board.vo.in;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CreateEventRequestVo {

    private String boardTitle;
    private String boardContent;
    private LocalDateTime endDate;
    private List<BoardImageRequestVo> boardImageRequestVoList;

    @Builder
    public CreateEventRequestVo(
            String boardTitle, String boardContent,
            LocalDateTime endDate, List<BoardImageRequestVo> boardImageRequestVoList
    ) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.endDate = endDate;
        this.boardImageRequestVoList = boardImageRequestVoList;
    }
}
