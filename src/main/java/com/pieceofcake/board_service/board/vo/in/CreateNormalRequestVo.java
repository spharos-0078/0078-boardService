package com.pieceofcake.board_service.board.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateNormalRequestVo {
    private String boardTitle;
    private String boardContent;
    private String mainCategoryId;
    private String subCategoryId;
    private String mainCategoryName;
    private String subCategoryName;
    private List<BoardImageRequestVo> boardImageRequestVoList;

    @Builder
    public CreateNormalRequestVo(
            String boardTitle, String boardContent, String mainCategoryId,
            String subCategoryId, String mainCategoryName, String subCategoryName,
            List<BoardImageRequestVo> boardImageRequestVoList
    ) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.mainCategoryId = mainCategoryId;
        this.subCategoryId = subCategoryId;
        this.mainCategoryName = mainCategoryName;
        this.subCategoryName = subCategoryName;
        this.boardImageRequestVoList = boardImageRequestVoList;
    }
}
