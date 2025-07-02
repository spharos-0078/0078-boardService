package com.pieceofcake.board_service.board.vo.in;

import com.pieceofcake.board_service.board.domain.BoardCategory;
import com.pieceofcake.board_service.board.domain.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateSaleRequestVo {

    @NotBlank(message = "게시글 제목은 필수입니다")
    @Size(min = 1, max = 100, message = "게시글 제목은 1-100자 사이여야 합니다")
    private String boardTitle;
    
    @NotBlank(message = "게시글 내용은 필수입니다")
    @Size(min = 1, max = 2000, message = "게시글 내용은 1-2000자 사이여야 합니다")
    private String boardContent;
    
    @NotNull(message = "희망 가격은 필수입니다")
    @Min(value = 1, message = "희망 가격은 1원 이상이어야 합니다")
    @Max(value = 999999999, message = "희망 가격은 999,999,999원 이하여야 합니다")
    private Long desiredPrice;
    
    @NotBlank(message = "메인 카테고리 ID는 필수입니다")
    private String mainCategoryId;
    
    @NotBlank(message = "서브 카테고리 ID는 필수입니다")
    private String subCategoryId;
    
    @NotBlank(message = "메인 카테고리명은 필수입니다")
    @Size(min = 1, max = 50, message = "메인 카테고리명은 1-50자 사이여야 합니다")
    private String mainCategoryName;
    
    @NotBlank(message = "서브 카테고리명은 필수입니다")
    @Size(min = 1, max = 50, message = "서브 카테고리명은 1-50자 사이여야 합니다")
    private String subCategoryName;
    
    @Size(max = 10, message = "이미지는 최대 10개까지 업로드 가능합니다")
    private List<BoardImageRequestVo> boardImageRequestVoList;

    @Builder
    public CreateSaleRequestVo(
            String boardTitle, String boardContent,
            Long desiredPrice, String mainCategoryId, String subCategoryId,
            String mainCategoryName, String subCategoryName, List<BoardImageRequestVo> boardImageRequestVoList
    ) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.desiredPrice = desiredPrice;
        this.mainCategoryId = mainCategoryId;
        this.subCategoryId = subCategoryId;
        this.mainCategoryName = mainCategoryName;
        this.subCategoryName = subCategoryName;
        this.boardImageRequestVoList = boardImageRequestVoList;
    }
}
