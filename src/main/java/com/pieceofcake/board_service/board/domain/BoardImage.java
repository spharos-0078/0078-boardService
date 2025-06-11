package com.pieceofcake.board_service.board.domain;

import com.pieceofcake.board_service.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Document(collection = "board_images")
public class BoardImage extends BaseEntity {
    @Id
    private String id;

    // 게시판 Uuid
    private String boardUuid;

    // 게시판 이미지 Url
    private String boardImageUrl;

    // 게시판 이미지 순서
    private Integer boardImageOrder;

    // 게시판 썸네일 여부
    private Boolean boardThumbnail;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public BoardImage(
            String id,
            String boardUuid,
            String boardImageUrl,
            Integer boardImageOrder,
            Boolean boardThumbnail,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.boardUuid = boardUuid;
        this.boardImageUrl = boardImageUrl;
        this.boardImageOrder = boardImageOrder;
        this.boardThumbnail = boardThumbnail;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}