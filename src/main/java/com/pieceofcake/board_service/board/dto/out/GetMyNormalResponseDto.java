package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.vo.out.GetMyNormalResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetMyNormalResponseDto {
    private String boardTitle;
    private String boardContent;
    private LocalDateTime createdAt;
    private String mainCategoryId;
    private String mainCategoryName;
    private String subCategoryId;
    private String subCategoryName;
    private List<BoardImageVo> images;

    @Getter
    @Builder
    public static class BoardImageVo {
        private String boardImageUrl;
        private Integer boardImageOrder;
    }

    @Builder
    public GetMyNormalResponseDto(
            String boardTitle, String boardContent, LocalDateTime createdAt,
            String mainCategoryId, String mainCategoryName, String subCategoryId,
            String subCategoryName, List<BoardImageVo> images
    ) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createdAt = createdAt;
        this.mainCategoryId = mainCategoryId;
        this.mainCategoryName = mainCategoryName;
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.images = images;
    }

    public static GetMyNormalResponseDto from (Board board, List<BoardImageVo> boardImages) {
        return GetMyNormalResponseDto.builder()
                .boardTitle(board.getBoardTitle())
                .boardContent(board.getBoardContent())
                .createdAt(board.getCreatedAt())
                .mainCategoryId(board.getMainCategoryId())
                .mainCategoryName(board.getMainCategoryName())
                .subCategoryId(board.getSubCategoryId())
                .subCategoryName(board.getSubCategoryName())
                .images(boardImages.stream()
                        .map(img -> BoardImageVo.builder()
                                .boardImageUrl(img.getBoardImageUrl())
                                .boardImageOrder(img.getBoardImageOrder())
                                .build())
                        .toList())
                .build();
    }

    public GetMyNormalResponseVo toVo() {
        return GetMyNormalResponseVo.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .createdAt(createdAt)
                .mainCategoryId(mainCategoryId)
                .mainCategoryName(mainCategoryName)
                .subCategoryId(subCategoryId)
                .subCategoryName(subCategoryName)
                .images(
                        images.stream()
                                .map(img -> GetMyNormalResponseVo.BoardImageVo.builder()
                                        .boardImageUrl(img.getBoardImageUrl())
                                        .boardImageOrder(img.getBoardImageOrder())
                                        .build()
                                )
                                .toList()
                )
                .build();
    }
}
