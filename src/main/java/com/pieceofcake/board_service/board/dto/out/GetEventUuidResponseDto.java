package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.vo.out.GetEventUuidResponseVo;
import com.pieceofcake.board_service.board.vo.out.GetNoticeUuidResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetEventUuidResponseDto {
    private String boardUuid;

    @Builder
    public GetEventUuidResponseDto(String boardUuid) {
        this.boardUuid = boardUuid;
    }

    public static GetEventUuidResponseDto from(Board board) {
        return GetEventUuidResponseDto.builder()
                .boardUuid(board.getBoardUuid())
                .build();
    }

    public GetEventUuidResponseVo toVo() {
        return GetEventUuidResponseVo.builder()
                .boardUuid(this.boardUuid)
                .build();
    }
}
