package com.pieceofcake.board_service.board.dto.in;

import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.vo.in.CreateCommunityRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateCommunityRequestDto {

    private BoardType boardType;
    private String boardUuid;

    @Builder
    public CreateCommunityRequestDto(BoardType boardType, String boardUuid) {
        this.boardType = boardType;
        this.boardUuid = boardUuid;
    }

    public static CreateCommunityRequestDto from(CreateCommunityRequestVo createBoardRequestVo) {
        return CreateCommunityRequestDto.builder()
                .boardType(createBoardRequestVo.getBoardType())
                .boardUuid(createBoardRequestVo.getBoardUuid())
                .build();
    }
}
