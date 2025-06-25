package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardImage;
import com.pieceofcake.board_service.board.vo.out.GetEventResponseVo;
import com.pieceofcake.board_service.board.vo.out.GetFaqResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetFaqResponseDto {
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
    public GetFaqResponseDto(String boardTitle, String boardContent, LocalDateTime createdAt, List<BoardImageVo> images) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createdAt = createdAt;
        this.images = images;
    }


    public static GetFaqResponseDto from(Board board, List<BoardImage> boardImages) {
        return GetFaqResponseDto.builder()
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

    public GetFaqResponseVo toVo() {
        return GetFaqResponseVo.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .createdAt(createdAt)
                .images(
                        images.stream()
                                .map(img -> GetFaqResponseVo.BoardImageVo.builder()
                                        .boardImageUrl(img.getBoardImageUrl())
                                        .boardImageOrder(img.getBoardImageOrder())
                                        .build()
                                )
                                .toList()
                )
                .build();
    }
}
