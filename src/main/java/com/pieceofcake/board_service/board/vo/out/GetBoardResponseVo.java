package com.pieceofcake.board_service.board.vo.out;

import com.pieceofcake.board_service.board.entity.BoardCategory;
import com.pieceofcake.board_service.board.entity.BoardState;
import com.pieceofcake.board_service.board.entity.BoardType;
import lombok.Builder;

import java.time.LocalDateTime;

public class GetBoardResponseVo {

    private String boardUuid;
    private String boardTitle;
    private String boardContent;
    private String memberUuid;
    private String memberNickname;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BoardType boardType;
    private BoardState boardState;
    private BoardCategory boardCategory;

    @Builder
    public GetBoardResponseVo(
            String boardUuid, String boardTitle, String boardContent, String memberUuid,
            String memberNickname, LocalDateTime startDate, LocalDateTime endDate,
            BoardType boardType, BoardState boardState, BoardCategory boardCategory
    ) {
        this.boardUuid = boardUuid;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.memberUuid = memberUuid;
        this.memberNickname = memberNickname;
        this.startDate = startDate;
        this.endDate = endDate;
        this.boardType = boardType;
        this.boardState = boardState;
        this.boardCategory = boardCategory;
    }


}
