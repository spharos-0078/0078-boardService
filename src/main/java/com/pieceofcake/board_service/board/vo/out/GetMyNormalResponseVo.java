package com.pieceofcake.board_service.board.vo.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.dto.out.GetMyNormalResponseDto;
import com.pieceofcake.board_service.board.dto.out.GetMySaleResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetMyNormalResponseVo {
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
    public GetMyNormalResponseVo(
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
}
