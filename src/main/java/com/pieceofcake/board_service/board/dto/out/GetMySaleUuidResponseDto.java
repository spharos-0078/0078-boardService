package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.vo.out.GetMySaleUuidResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetMySaleUuidResponseDto {
    private String boardUuid;

    @Builder
    public GetMySaleUuidResponseDto(String boardUuid) {
        this.boardUuid = boardUuid;
    }

    public static GetMySaleUuidResponseDto from(Board board) {
        return GetMySaleUuidResponseDto.builder()
                .boardUuid(board.getBoardUuid())
                .build();
    }

    public GetMySaleUuidResponseVo toVo() {
        return GetMySaleUuidResponseVo.builder()
                .boardUuid(boardUuid)
                .build();
    }
}
