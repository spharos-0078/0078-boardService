package com.pieceofcake.board_service.board.dto.in;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.vo.in.CreateFaqRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateFaqRequestDto {

    private String memberUuid;
    private String boardUuid;
    private String boardTitle;
    private String boardContent;
    private List<BoardImageRequestDto> boardImageRequestDtoList;

    @Builder
    public CreateFaqRequestDto(
            String memberUuid, String boardUuid, String boardTitle,
            String boardContent, List<BoardImageRequestDto> boardImageRequestDtoList
    ) {
        this.memberUuid = memberUuid;
        this.boardUuid = boardUuid;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardImageRequestDtoList = boardImageRequestDtoList;
    }

    public static CreateFaqRequestDto from(String memberUuid, CreateFaqRequestVo createFaqRequestVo) {
        return CreateFaqRequestDto.builder()
                .boardUuid(UUID.randomUUID().toString().substring(0, 32))
                .memberUuid(memberUuid)
                .boardTitle(createFaqRequestVo.getBoardTitle())
                .boardContent(createFaqRequestVo.getBoardContent())
                .boardImageRequestDtoList(
                        createFaqRequestVo.getBoardImageRequestVoList().stream()
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
                .boardType(BoardType.FAQ)
                .memberUuid(memberUuid)
                .boardTitle(this.boardTitle)
                .boardContent(this.boardContent)
                .deleted(false)
                .build();
    }
}
