package com.pieceofcake.board_service.board.dto.in;

import com.pieceofcake.board_service.board.domain.BoardImage;
import com.pieceofcake.board_service.board.vo.in.BoardImageRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardImageRequestDto {

    private String boardImageUrl;
    private Integer boardImageOrder;
    private Boolean boardThumbnail;

    @Builder
    public BoardImageRequestDto(
            String boardImageUrl, Integer boardImageOrder, Boolean boardThumbnail
    ) {
        this.boardImageUrl = boardImageUrl;
        this.boardImageOrder = boardImageOrder;
        this.boardThumbnail = boardThumbnail;
    }

    public static BoardImageRequestDto from(BoardImageRequestVo boardImageRequestVo) {
        return BoardImageRequestDto.builder()
                .boardImageUrl(boardImageRequestVo.getBoardImageUrl())
                .boardImageOrder(boardImageRequestVo.getBoardImageOrder())
                .boardThumbnail(boardImageRequestVo.getBoardThumbnail())
                .build();
    }

    public BoardImage toEntity(String boardUuid) {
        return BoardImage.builder()
                .boardUuid(boardUuid)
                .boardImageUrl(boardImageUrl)
                .boardImageOrder(boardImageOrder)
                .boardThumbnail(boardThumbnail)
                .build();
    }
}
