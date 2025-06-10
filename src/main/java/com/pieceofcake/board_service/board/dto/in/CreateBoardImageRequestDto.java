package com.pieceofcake.board_service.board.dto.in;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardImage;
import com.pieceofcake.board_service.board.vo.in.CreateBoardImageRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateBoardImageRequestDto {

    private String boardUuid;
    private List<BoardImageRequestDto> boardImageRequestDtoList;

    @Builder
    public CreateBoardImageRequestDto(
            String boardUuid, List<BoardImageRequestDto> boardImageRequestDtoList
    ) {
        this.boardUuid = boardUuid;
        this.boardImageRequestDtoList = boardImageRequestDtoList;
    }

    public static CreateBoardImageRequestDto of(
            String boardUuid, List<BoardImageRequestDto> boardImageRequestDtoList
    ) {
        return CreateBoardImageRequestDto.builder()
                .boardUuid(boardUuid)
                .boardImageRequestDtoList(boardImageRequestDtoList)
                .build();
    }
}
