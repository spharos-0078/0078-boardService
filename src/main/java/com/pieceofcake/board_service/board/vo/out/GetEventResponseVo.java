package com.pieceofcake.board_service.board.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetEventResponseVo {
    private String boardTitle;
    private String boardContent;
    private LocalDateTime createdAt;
    private List<BoardImageVo> images;

    @Getter
    @Builder
    public static class BoardImageVo {
        private String boardImageUrl;
        private Integer boardImageOrder;
    }

    @Builder
    public GetEventResponseVo(String boardTitle, String boardContent, LocalDateTime createdAt, List<BoardImageVo> images) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createdAt = createdAt;
        this.images = images;
    }
}
