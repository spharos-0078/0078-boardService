package com.pieceofcake.board_service.board.vo.in;

import com.pieceofcake.board_service.board.domain.BoardCategory;
import com.pieceofcake.board_service.board.domain.BoardType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UpdateBoardRequestVo {

    private String boardTitle;
    private String boardContent;
    private LocalDateTime endDate;
    private BoardType boardType;
    private BoardCategory boardCategory;

}
