package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardImage;
import com.pieceofcake.board_service.board.vo.out.GetNoticeResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetNoticeResponseDto {

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
    public GetNoticeResponseDto(String boardTitle, String boardContent, LocalDateTime createdAt, List<BoardImageVo> images) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createdAt = createdAt;
        this.images = images;
    }


    public static GetNoticeResponseDto from(Board board, List<BoardImage> boardImages) {
        return GetNoticeResponseDto.builder()
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

    public GetNoticeResponseVo toVo() {
        return GetNoticeResponseVo.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .createdAt(createdAt)
                .images(
                        images.stream()
                                .map(img -> GetNoticeResponseVo.BoardImageVo.builder()
                                        .boardImageUrl(img.getBoardImageUrl())
                                        .boardImageOrder(img.getBoardImageOrder())
                                        .build()
                                )
                                .toList()
                )
                .build();
    }

}
