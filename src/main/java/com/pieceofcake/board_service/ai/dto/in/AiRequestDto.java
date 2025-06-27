package com.pieceofcake.board_service.ai.dto.in;

import com.pieceofcake.board_service.ai.vo.in.AiRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class AiRequestDto {
    private String description;  // 물품 설명
    private String imageUrls;

    @Builder
    public AiRequestDto(String description, String imageUrls) {
        this.description = description;
        this.imageUrls = imageUrls;
    }

    public static AiRequestDto from(AiRequestVo aiRequestVo) {
        return AiRequestDto.builder()
                .description(aiRequestVo.getDescription())
                .imageUrls(aiRequestVo.getImageUrl())
                .build();
    }

    public static AiRequestDto of(String description, String imageUrls) {
        return AiRequestDto.builder()
                .description(description)
                .imageUrls(imageUrls)
                .build();
    }

}
