package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.vo.out.GetFaqUuidResponseVo;
import com.pieceofcake.board_service.board.vo.out.GetNoticeUuidResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetFaqUuidResponseDto {
    private String boardUuid;

    @Builder
    public GetFaqUuidResponseDto(String boardUuid) {
        this.boardUuid = boardUuid;
    }

    public static GetFaqUuidResponseDto from(Board board) {
        return GetFaqUuidResponseDto.builder()
                .boardUuid(board.getBoardUuid())
                .build();
    }

    public GetFaqUuidResponseVo toVo() {
        return GetFaqUuidResponseVo.builder()
                .boardUuid(this.boardUuid)
                .build();
    }
}
