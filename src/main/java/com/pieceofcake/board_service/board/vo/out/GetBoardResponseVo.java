package com.pieceofcake.board_service.board.vo.out;

import com.pieceofcake.board_service.board.domain.BoardCategory;
import com.pieceofcake.board_service.board.domain.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetBoardResponseVo {

    private String boardUuid;
    private String memberUuid;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime createdAt;
    private LocalDateTime endDate;
    private BoardType boardType;
    private BoardCategory boardCategory;

    @Builder
    public GetBoardResponseVo(
            String boardUuid, String boardTitle, String boardContent, String memberUuid,
            LocalDateTime createdAt, LocalDateTime endDate,
            BoardType boardType, BoardCategory boardCategory
    ) {
        this.boardUuid = boardUuid;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.memberUuid = memberUuid;
        this.createdAt = createdAt;
        this.endDate = endDate;
        this.boardType = boardType;
        this.boardCategory = boardCategory;
    }


}
