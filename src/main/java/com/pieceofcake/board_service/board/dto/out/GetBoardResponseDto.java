package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.entity.Board;
import com.pieceofcake.board_service.board.entity.BoardCategory;
import com.pieceofcake.board_service.board.entity.BoardState;
import com.pieceofcake.board_service.board.entity.BoardType;
import com.pieceofcake.board_service.board.vo.out.GetBoardResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetBoardResponseDto {

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
    public GetBoardResponseDto(
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

    public static GetBoardResponseDto from(Board board) {
        return GetBoardResponseDto.builder()
                .boardUuid(board.getBoardUuid())
                .boardTitle(board.getBoardTitle())
                .boardContent(board.getBoardContent())
                .boardContent(board.getBoardContent())
                .memberUuid(board.getMemberUuid())
                .memberNickname(board.getMemberNickname())
                .startDate(board.getStartDate())
                .endDate(board.getEndDate())
                .boardType(board.getBoardType())
                .boardState(board.getBoardState())
                .boardCategory(board.getBoardCategory())
                .build();
    }

    public GetBoardResponseVo toVo() {
        return GetBoardResponseVo.builder()
                .boardUuid(this.boardUuid)
                .boardTitle(this.boardTitle)
                .boardContent(this.boardContent)
                .memberUuid(this.memberUuid)
                .memberNickname(this.memberNickname)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .boardType(this.boardType)
                .boardState(this.boardState)
                .boardCategory(this.boardCategory)
                .build();
    }

}
