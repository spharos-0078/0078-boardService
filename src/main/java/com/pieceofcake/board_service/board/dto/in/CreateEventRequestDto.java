package com.pieceofcake.board_service.board.dto.in;

import com.pieceofcake.board_service.board.domain.Board;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.vo.in.BoardImageRequestVo;
import com.pieceofcake.board_service.board.vo.in.CreateEventRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateEventRequestDto {

    private String memberUuid;
    private String boardUuid;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime endDate;
    private List<BoardImageRequestDto> boardImageRequestDtoList;

    @Builder
    public CreateEventRequestDto(
            String memberUuid, String boardUuid, String boardTitle,
            String boardContent, LocalDateTime endDate, List<BoardImageRequestDto> boardImageRequestDtoList
    ) {
        this.memberUuid = memberUuid;
        this.boardUuid = boardUuid;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.endDate = endDate;
        this.boardImageRequestDtoList = boardImageRequestDtoList;
    }

    public static CreateEventRequestDto from(String memberUuid, CreateEventRequestVo createEventRequestVo) {
        return CreateEventRequestDto.builder()
                .boardUuid(UUID.randomUUID().toString().substring(0, 32))
                .memberUuid(memberUuid)
                .boardTitle(createEventRequestVo.getBoardTitle())
                .boardContent(createEventRequestVo.getBoardContent())
                .endDate(createEventRequestVo.getEndDate())
                .boardImageRequestDtoList(
                        createEventRequestVo.getBoardImageRequestVoList().stream()
                                .map(img -> BoardImageRequestDto.builder()
                                        .boardImageUrl(img.getBoardImageUrl())
                                        .boardImageOrder(img.getBoardImageOrder())
                                        .boardThumbnail(img.getBoardThumbnail())
                                        .build())
                                .toList()
                )
                .build();
    }

    public Board toEntity() {
        return Board.builder()
                .boardUuid(this.boardUuid)
                .boardType(BoardType.EVENT)
                .boardTitle(boardTitle)
                .memberUuid(memberUuid)
                .boardContent(boardContent)
                .endDate(endDate)
                .deleted(false)
                .build();
    }

}
