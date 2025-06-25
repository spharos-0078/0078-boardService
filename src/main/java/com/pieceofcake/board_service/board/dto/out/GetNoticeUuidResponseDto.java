package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.vo.out.GetNoticeUuidResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetNoticeUuidResponseDto {

    private String boardUuid;

    @Builder
    public GetNoticeUuidResponseDto(String boardUuid) {
        this.boardUuid = boardUuid;
    }

    public static GetNoticeUuidResponseDto from(Board board) {
        return GetNoticeUuidResponseDto.builder()
                .boardUuid(board.getBoardUuid())
                .build();
    }

    public GetNoticeUuidResponseVo toVo() {
        return GetNoticeUuidResponseVo.builder()
                .boardUuid(this.boardUuid)
                .build();
    }
}
