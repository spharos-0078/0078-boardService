package com.pieceofcake.board_service.board.dto.in;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.vo.in.CreateNormalRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateNormalRequestDto {
    private String memberUuid;
    private String boardUuid;
    private String boardTitle;
    private String boardContent;
    private String mainCategoryId;
    private String subCategoryId;
    private String mainCategoryName;
    private String subCategoryName;
    private List<BoardImageRequestDto> boardImageRequestDtoList;

    @Builder
    public CreateNormalRequestDto(
            String memberUuid, String boardUuid,
            String boardTitle, String boardContent, String mainCategoryId,
            String subCategoryId, String mainCategoryName, String subCategoryName,
            List<BoardImageRequestDto> boardImageRequestDtoList
    ) {
        this.memberUuid = memberUuid;
        this.boardUuid = boardUuid;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.mainCategoryId = mainCategoryId;
        this.subCategoryId = subCategoryId;
        this.mainCategoryName = mainCategoryName;
        this.subCategoryName = subCategoryName;
        this.boardImageRequestDtoList = boardImageRequestDtoList;
    }

    public static CreateNormalRequestDto from(String memberUuid, CreateNormalRequestVo createNormalRequestVo) {
        return CreateNormalRequestDto.builder()
                .boardUuid(UUID.randomUUID().toString().substring(0, 32))
                .memberUuid(memberUuid)
                .boardTitle(createNormalRequestVo.getBoardTitle())
                .boardContent(createNormalRequestVo.getBoardContent())
                .mainCategoryId(createNormalRequestVo.getMainCategoryId())
                .subCategoryId(createNormalRequestVo.getSubCategoryId())
                .mainCategoryName(createNormalRequestVo.getMainCategoryName())
                .subCategoryName(createNormalRequestVo.getSubCategoryName())
                .boardImageRequestDtoList(
                        createNormalRequestVo.getBoardImageRequestVoList().stream()
                                .map(img -> BoardImageRequestDto.builder()
                                        .boardImageUrl(img.getBoardImageUrl())
                                        .boardImageOrder(img.getBoardImageOrder())
                                        .boardThumbnail(img.getBoardThumbnail())
                                        .build())
                                .toList()
                )
                .build();
    }

    public Board toEntity() {
        return Board.builder()
                .boardUuid(this.boardUuid)
                .boardTitle(boardTitle)
                .boardType(BoardType.NORMAL_REQUEST)
                .boardContent(boardContent)
                .mainCategoryId(mainCategoryId)
                .subCategoryId(subCategoryId)
                .mainCategoryName(mainCategoryName)
                .subCategoryName(subCategoryName)
                .deleted(false)
                .build();
    }
}
