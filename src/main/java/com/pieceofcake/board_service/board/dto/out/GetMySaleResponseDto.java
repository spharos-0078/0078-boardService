package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.vo.out.GetMySaleResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetMySaleResponseDto {
    private String boardTitle;
    private String boardContent;
    private LocalDateTime createdAt;
    private Long desiredPrice;
    private Long aiEstimatedPrice;
    private String aiEstimatedDescription;
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
    public GetMySaleResponseDto(
            String boardTitle, String boardContent, LocalDateTime createdAt,
            Long desiredPrice, Long aiEstimatedPrice, String aiEstimatedDescription,
            String mainCategoryId, String mainCategoryName, String subCategoryId,
            String subCategoryName, List<BoardImageVo> images
    ) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createdAt = createdAt;
        this.desiredPrice = desiredPrice;
        this.aiEstimatedPrice = aiEstimatedPrice;
        this.aiEstimatedDescription = aiEstimatedDescription;
        this.mainCategoryId = mainCategoryId;
        this.mainCategoryName = mainCategoryName;
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.images = images;
    }

    public static GetMySaleResponseDto from(Board board, List<BoardImageVo> boardImages) {
        return GetMySaleResponseDto.builder()
                .boardTitle(board.getBoardTitle())
                .boardContent(board.getBoardContent())
                .createdAt(board.getCreatedAt())
                .desiredPrice(board.getDesiredPrice())
                .aiEstimatedPrice(board.getAiEstimatedPrice())
                .aiEstimatedDescription(board.getAiEstimatedDescription())
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

    public GetMySaleResponseVo toVo() {
        return GetMySaleResponseVo.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .createdAt(createdAt)
                .desiredPrice(desiredPrice)
                .aiEstimatedPrice(aiEstimatedPrice)
                .aiEstimatedDescription(aiEstimatedDescription)
                .mainCategoryId(mainCategoryId)
                .mainCategoryName(mainCategoryName)
                .subCategoryId(subCategoryId)
                .subCategoryName(subCategoryName)
                .images(
                        images.stream()
                                .map(img -> GetMySaleResponseVo.BoardImageVo.builder()
                                        .boardImageUrl(img.getBoardImageUrl())
                                        .boardImageOrder(img.getBoardImageOrder())
                                        .build()
                                )
                                .toList()
                )
                .build();
    }
}