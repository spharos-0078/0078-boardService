package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardImage;
import com.pieceofcake.board_service.board.vo.out.GetEventResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetEventResponseDto {

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
    public GetEventResponseDto(String boardTitle, String boardContent, LocalDateTime createdAt, List<BoardImageVo> images) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createdAt = createdAt;
        this.images = images;
    }


    public static GetEventResponseDto from(Board board, List<BoardImage> boardImages) {
        return GetEventResponseDto.builder()
                .boardTitle(board.getBoardTitle())
                .boardContent(board.getBoardContent())
                .createdAt(board.getCreatedAt())
                .images(boardImages.stream()
                        .map(img -> BoardImageVo.builder()
                                .boardImageUrl(img.getBoardImageUrl())
                                .boardImageOrder(img.getBoardImageOrder())
                                .build())
                        .toList())
                .build();
    }

    public GetEventResponseVo toVo() {
        return GetEventResponseVo.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .createdAt(createdAt)
                .images(
                        images.stream()
                                .map(img -> GetEventResponseVo.BoardImageVo.builder()
                                        .boardImageUrl(img.getBoardImageUrl())
                                        .boardImageOrder(img.getBoardImageOrder())
                                        .build()
                                )
                                .toList()
                )
                .build();
    }

}
