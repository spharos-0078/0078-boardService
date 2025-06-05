package com.pieceofcake.board_service.board.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String boardUuid;

    @Column(nullable = false, length = 100)
    private String boardTitle;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String boardContent;

    @Column(nullable = false)
    private String memberUuid;

    @Column(nullable = false, unique = true)
    private String memberNickname;

    @Column(nullable = false)
    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Column(nullable = false)
    private BoardType boardType;

    @Column(nullable = false)
    private BoardState boardState;

    @Column(nullable = false)
    private BoardCategory boardCategory;

    @Builder
    public Board(
            Long id,
            String boardUuid,
            String boardTitle,
            String boardContent,
            String memberUuid,
            String memberNickname,
            LocalDateTime startDate,
            LocalDateTime endDate,
            BoardType boardType,
            BoardState boardState,
            BoardCategory boardCategory
    ) {
        this.id = id;
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
}