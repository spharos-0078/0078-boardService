package com.pieceofcake.board_service.board.vo.in;

import com.pieceofcake.board_service.board.domain.BoardCategory;
import com.pieceofcake.board_service.board.domain.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateSaleRequestVo {

    private String boardTitle;
    private String boardContent;
    private BoardType boardType;
    private Long desiredPrice;
    private String mainCategoryId;
    private String subCategoryId;
    private String mainCategoryName;
    private String subCategoryName;
    private List<BoardImageRequestVo> boardImageRequestVoList;

    @Builder
    public CreateSaleRequestVo(
            String boardTitle, String boardContent, BoardType boardType,
            Long desiredPrice, String mainCategoryId, String subCategoryId,
            String mainCategoryName, String subCategoryName, List<BoardImageRequestVo> boardImageRequestVoList
    ) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardType = boardType;
        this.desiredPrice = desiredPrice;
        this.mainCategoryId = mainCategoryId;
        this.subCategoryId = subCategoryId;
        this.mainCategoryName = mainCategoryName;
        this.subCategoryName = subCategoryName;
        this.boardImageRequestVoList = boardImageRequestVoList;
    }
}
