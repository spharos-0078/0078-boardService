package com.pieceofcake.board_service.board.dto.in;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.vo.in.BoardImageRequestVo;
import com.pieceofcake.board_service.board.vo.in.CreateSaleRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateSaleRequestDto {

    private String memberUuid;
    private String boardUuid;
    private String boardTitle;
    private String boardContent;
    private Long desiredPrice;
    private String mainCategoryId;
    private String subCategoryId;
    private String mainCategoryName;
    private String subCategoryName;
    private List<BoardImageRequestDto> boardImageRequestDtoList;

    private Long aiEstimatedPrice;
    private String aiEstimatedDescription;

    @Builder
    public CreateSaleRequestDto(
            String memberUuid, String boardUuid, String boardTitle,
            String boardContent, Long desiredPrice, String mainCategoryId,
            String subCategoryId, String mainCategoryName,
            String subCategoryName, List<BoardImageRequestDto> boardImageRequestDtoList,
            Long aiEstimatedPrice, String aiEstimatedDescription
    ) {
        this.memberUuid = memberUuid;
        this.boardUuid = boardUuid;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.desiredPrice = desiredPrice;
        this.mainCategoryId = mainCategoryId;
        this.subCategoryId = subCategoryId;
        this.mainCategoryName = mainCategoryName;
        this.subCategoryName = subCategoryName;
        this.boardImageRequestDtoList = boardImageRequestDtoList;
        this.aiEstimatedPrice = aiEstimatedPrice;
        this.aiEstimatedDescription = aiEstimatedDescription;
    }

    public static CreateSaleRequestDto from(String memberUuid, CreateSaleRequestVo createSaleRequestVo) {
        return CreateSaleRequestDto.builder()
                .boardUuid(UUID.randomUUID().toString().substring(0, 32))
                .memberUuid(memberUuid)
                .boardTitle(createSaleRequestVo.getBoardTitle())
                .boardContent(createSaleRequestVo.getBoardContent())
                .desiredPrice(createSaleRequestVo.getDesiredPrice())
                .mainCategoryId(createSaleRequestVo.getMainCategoryId())
                .subCategoryId(createSaleRequestVo.getSubCategoryId())
                .mainCategoryName(createSaleRequestVo.getMainCategoryName())
                .subCategoryName(createSaleRequestVo.getSubCategoryName())
                .boardImageRequestDtoList(
                        createSaleRequestVo.getBoardImageRequestVoList().stream()
                                .map(img -> BoardImageRequestDto.builder()
                                        .boardImageUrl(img.getBoardImageUrl())
                                        .boardImageOrder(img.getBoardImageOrder())
                                        .boardThumbnail(img.getBoardThumbnail())
                                        .build())
                                .toList()
                )
                .build();
    }

    public Board toEntity(String boardUuid, Long aiEstimatedPrice, String aiEstimatedDescription) {
        return Board.builder()
                .memberUuid(memberUuid)
                .boardUuid(boardUuid)
                .boardTitle(boardTitle)
                .boardType(BoardType.SALE_REQUEST)
                .boardContent(boardContent)
                .desiredPrice(desiredPrice)
                .mainCategoryId(mainCategoryId)
                .subCategoryId(subCategoryId)
                .mainCategoryName(mainCategoryName)
                .subCategoryName(subCategoryName)
                .aiEstimatedPrice(aiEstimatedPrice)
                .aiEstimatedDescription(aiEstimatedDescription)
                .deleted(false)
                .build();
    }

    public List<String> getBoardImageRequestDtoUrlList() {
        return this.boardImageRequestDtoList == null
                ? List.of()
                : this.boardImageRequestDtoList.stream()
                .map(BoardImageRequestDto::getBoardImageUrl)
                .toList();
    }
}