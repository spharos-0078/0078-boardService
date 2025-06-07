package com.pieceofcake.board_service.board.vo.in;

import com.pieceofcake.board_service.board.domain.BoardCategory;
import com.pieceofcake.board_service.board.domain.BoardType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreateSaleRequestVo {

    private String boardTitle;
    private String boardContent;
    private LocalDateTime createdAt;
    private BoardType boardType;
    private BoardCategory boardCategory;
    private Long desiredPrice;
    private String mainCategoryId;
    private String subCategoryId;
    private String mainCategoryName;
    private String subCategoryName;

}
