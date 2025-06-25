package com.pieceofcake.board_service.board.dto.in;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardCategory;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.vo.in.CreateBoardRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CreateBoardRequestDto {

    private String boardUuid;
    private String boardTitle;
    private String boardContent;
    private String memberUuid;
    private LocalDateTime endDate;
    private BoardType boardType;
    private List<BoardImageRequestDto> boardImageRequestDtoList;

    @Builder
    public CreateBoardRequestDto(String boardUuid, String boardTitle, String boardContent,
                                 String memberUuid, LocalDateTime endDate,
                                 BoardType boardType, List<BoardImageRequestDto> boardImageRequestDtoList
    ) {
        this.boardUuid = boardUuid;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.memberUuid = memberUuid;
        this.endDate = endDate;
        this.boardType = boardType;
        this.boardImageRequestDtoList = boardImageRequestDtoList;
    }

    public static CreateBoardRequestDto from(String memberUuid, CreateBoardRequestVo createBoardRequestVo) {
        return CreateBoardRequestDto.builder()
                .boardUuid(UUID.randomUUID().toString().substring(0, 32))
                .boardTitle(createBoardRequestVo.getBoardTitle())
                .boardContent(createBoardRequestVo.getBoardContent())
                .memberUuid(memberUuid)
                .endDate(createBoardRequestVo.getEndDate())
                .boardType(createBoardRequestVo.getBoardType())
                .boardImageRequestDtoList(createBoardRequestVo.getBoardImageRequestVoList()
                        .stream().map(BoardImageRequestDto::from).toList())
                .build();
    }

    public Board toEntity(String boardUuid) {
        return Board.builder()
                .boardUuid(boardUuid)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .memberUuid(memberUuid)
                .endDate(endDate)
                .boardType(boardType)
                .build();
    }
}
