package com.pieceofcake.board_service.board.vo.in;

import com.pieceofcake.board_service.board.domain.BoardCategory;
import com.pieceofcake.board_service.board.domain.BoardType;

import java.time.LocalDateTime;

public class UpdateSaleRequestVo {

    private String boardTitle;
    private String boardContent;
    private BoardType boardType;
    private BoardCategory boardCategory;
    private Long desiredPrice;
    private String mainCategoryId;
    private String subCategoryId;
    private String mainCategoryName;
    private String subCategoryName;

}
