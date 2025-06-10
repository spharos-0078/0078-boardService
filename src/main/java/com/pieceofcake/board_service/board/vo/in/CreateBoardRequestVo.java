package com.pieceofcake.board_service.board.vo.in;

import com.pieceofcake.board_service.board.domain.BoardCategory;
import com.pieceofcake.board_service.board.domain.BoardType;
import com.pieceofcake.board_service.board.dto.in.BoardImageRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateBoardRequestVo {

    private String boardTitle;
    private String boardContent;
    private LocalDateTime createdAt;
    private LocalDateTime endDate;
    private BoardType boardType;
    private BoardCategory boardCategory;
    private List<BoardImageRequestVo> boardImageRequestVoList;

    @Builder
    public CreateBoardRequestVo(
            String boardTitle, String boardContent, LocalDateTime createdAt,
            LocalDateTime endDate, BoardType boardType, BoardCategory boardCategory,
            List<BoardImageRequestVo> boardImageRequestVoList
    ) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createdAt = createdAt;
        this.endDate = endDate;
        this.boardType = boardType;
        this.boardCategory = boardCategory;
        this.boardImageRequestVoList = boardImageRequestVoList;
    }
}
