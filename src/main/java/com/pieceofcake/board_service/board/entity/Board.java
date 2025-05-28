package com.pieceofcake.board_service.board.entity;

import com.pieceofcake.board_service.board.enums.BoardCategory;
import com.pieceofcake.board_service.board.enums.BoardState;
import com.pieceofcake.board_service.board.enums.BoardType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
}
