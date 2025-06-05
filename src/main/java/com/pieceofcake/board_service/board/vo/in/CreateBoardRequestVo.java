package com.pieceofcake.board_service.board.vo.in;

import com.pieceofcake.board_service.board.entity.BoardCategory;
import com.pieceofcake.board_service.board.entity.BoardState;
import com.pieceofcake.board_service.board.entity.BoardType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreateBoardRequestVo {

    private String boardTitle;
    private String boardContent;
    private String memberNickname;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BoardType boardType;
    private BoardState boardState;
    private BoardCategory boardCategory;

}
