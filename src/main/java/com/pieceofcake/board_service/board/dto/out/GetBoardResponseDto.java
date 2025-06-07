package com.pieceofcake.board_service.board.dto.out;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardCategory;
import com.pieceofcake.board_service.board.domain.BoardType;
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
    private LocalDateTime createdAt;
    private LocalDateTime endDate;
    private BoardType boardType;
    private BoardCategory boardCategory;

    @Builder
    public GetBoardResponseDto(
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

    public static GetBoardResponseDto from(Board board) {
        return GetBoardResponseDto.builder()
                .boardUuid(board.getBoardUuid())
                .boardTitle(board.getBoardTitle())
                .boardContent(board.getBoardContent())
                .boardContent(board.getBoardContent())
                .memberUuid(board.getMemberUuid())
                .createdAt(board.getCreatedAt())
                .endDate(board.getEndDate())
                .boardType(board.getBoardType())
                .boardCategory(board.getBoardCategory())
                .build();
    }

    public GetBoardResponseVo toVo() {
        return GetBoardResponseVo.builder()
                .boardUuid(this.boardUuid)
                .boardTitle(this.boardTitle)
                .boardContent(this.boardContent)
                .memberUuid(this.memberUuid)
                .createdAt(this.createdAt)
                .endDate(this.endDate)
                .boardType(this.boardType)
                .boardCategory(this.boardCategory)
                .build();
    }

}
