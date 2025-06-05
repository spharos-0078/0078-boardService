package com.pieceofcake.board_service.board.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class BoardImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String boardUuid;

    @Column(nullable = false)
    private String boardImageUrl;

    @Column(nullable = false)
    private Integer boardImageIndex;

    @Builder
    public BoardImage(
            Long id,
            String boardUuid,
            String boardImageUrl,
            Integer boardImageIndex
    ) {
        this.id = id;
        this.boardUuid = boardUuid;
        this.boardImageUrl = boardImageUrl;
        this.boardImageIndex = boardImageIndex;
    }
}