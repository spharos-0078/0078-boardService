package com.pieceofcake.board_service.board.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetMySaleResponseVo {
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
    public GetMySaleResponseVo(
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
}
