package com.pieceofcake.board_service.board.dto.in;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardCategory;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.vo.in.CreateBoardRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateBoardRequestDto {

    private String boardUuid;
    private String boardTitle;
    private String boardContent;
    private String memberUuid;
    private LocalDateTime createdAt;
    private LocalDateTime endDate;
    private BoardType boardType;
    private BoardCategory boardCategory;

    @Builder
    public CreateBoardRequestDto(String boardUuid, String boardTitle, String boardContent,
                                 String memberUuid, LocalDateTime createdAt, LocalDateTime endDate,
                                 BoardType boardType, BoardCategory boardCategory) {
        this.boardUuid = boardUuid;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.memberUuid = memberUuid;
        this.createdAt = createdAt;
        this.endDate = endDate;
        this.boardType = boardType;
        this.boardCategory = boardCategory;
    }

    public static CreateBoardRequestDto from(String memberUuid, CreateBoardRequestVo createBoardRequestVo) {
        return CreateBoardRequestDto.builder()
                .boardUuid(UUID.randomUUID().toString().substring(0, 32))
                .boardTitle(createBoardRequestVo.getBoardTitle())
                .boardContent(createBoardRequestVo.getBoardContent())
                .memberUuid(memberUuid)
                .createdAt(createBoardRequestVo.getCreatedAt())
                .endDate(createBoardRequestVo.getEndDate())
                .boardType(createBoardRequestVo.getBoardType())
                .boardCategory(createBoardRequestVo.getBoardCategory())
                .build();
    }

    public Board toEntity() {
        return Board.builder()
                .boardUuid(boardUuid)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .memberUuid(memberUuid)
                .createdAt(createdAt)
                .endDate(endDate)
                .boardType(boardType)
                .boardCategory(boardCategory)
                .build();
    }
}
