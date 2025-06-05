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
    private String boardContent; // Text

    @Column(nullable = false)
    private String memberUuid;

    @Column(nullable = false, unique = true)
    private String memberNickname; // 빼는게 맞아용

    private LocalDateTime startDate; // null 값이 많을 수 있어서 아예 mongodb 사용하는 것이 나을 수도 있다

    private LocalDateTime endDate;

    @Column(nullable = false)
    private BoardType boardType; // 추가될 일이 많을 것 같을 때 -> enum 대신 table

    @Column(nullable = false)
    private BoardState boardState; // 상태가 하나라면 boolean으로

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