package com.pieceofcake.board_service.board.domain;

import com.pieceofcake.board_service.common.entity.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Document(collection = "board_db")
public class Board extends BaseEntity {
    @Id
    private String id;

    // 게시판 Uuid
    @Indexed
    private String boardUuid;

    // 게시판 유형
    private BoardType boardType;

    // 문의 답변 완료 여부
    private boolean boardAnswered = false;

    // 게시판 제목 or 판매문의 상품명
    private String boardTitle;

    // 게시판 내용
    private String boardContent;

    // 작성자 Uuid
    @Indexed
    private String memberUuid;

    // 마감일 (이벤트)
    private LocalDateTime endDate;

    // 판매 희망 가격
    private Long desiredPrice;

    // ai 예측 가격
    private Long aiEstimatedPrice;

    private String aiEstimatedDescription;

    // 메인 카테고리 ID
    private String mainCategoryId;

    // 서브 카테고리 ID
    private String subCategoryId;

    // 메인 카테고리 명
    private String mainCategoryName;

    // 서브 카테고리 명
    private String subCategoryName;

    private boolean deleted = false;

    @Builder
    public Board(
            String id,
            String boardUuid,
            BoardType boardType,
            boolean boardAnswered,
            String boardTitle,
            String boardContent,
            String memberUuid,
            LocalDateTime endDate,
            Long desiredPrice,
            Long aiEstimatedPrice,
            String aiEstimatedDescription,
            String mainCategoryId,
            String subCategoryId,
            String mainCategoryName,
            String subCategoryName,
            boolean deleted
    ) {
        this.id = id;
        this.boardUuid = boardUuid;
        this.boardType = boardType;
        this.boardAnswered = boardAnswered;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.memberUuid = memberUuid;
        this.endDate = endDate;
        this.desiredPrice = desiredPrice;
        this.aiEstimatedPrice = aiEstimatedPrice;
        this.aiEstimatedDescription = aiEstimatedDescription;
        this.mainCategoryId = mainCategoryId;
        this.subCategoryId = subCategoryId;
        this.mainCategoryName = mainCategoryName;
        this.subCategoryName = subCategoryName;
        this.deleted = deleted;
    }

    public void softDelete() { this.deleted = true; }
    
    public void markAsAnswered() { this.boardAnswered = true; }
    
    public void markAsUnanswered() { this.boardAnswered = false; }
    
    public boolean isAnswered() { return this.boardAnswered; }
    
    public boolean isDeleted() { return this.deleted; }
}