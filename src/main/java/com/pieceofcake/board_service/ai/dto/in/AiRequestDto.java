package com.pieceofcake.board_service.ai.dto.in;

import com.pieceofcake.board_service.ai.vo.in.AiRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class AiRequestDto {
    private String description;  // 물품 설명
    private List<String> imageUrls;

    @Builder
    public AiRequestDto(String description, List<String> imageUrls) {
        this.description = description;
        this.imageUrls = imageUrls;
    }

    public static AiRequestDto from(AiRequestVo aiRequestVo) {
        return AiRequestDto.builder()
                .description(aiRequestVo.getDescription())
                .imageUrls(
                        Arrays.stream(aiRequestVo.getImageUrl().split(","))
                                .map(String::trim) // 공백 제거
                                .collect(Collectors.toList())
                )
                .build();
    }

    public static AiRequestDto of(String description, String imageUrls) {
        return AiRequestDto.builder()
                .description(description)
                .imageUrls(
                        Arrays.stream(imageUrls.split(","))
                                .map(String::trim)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
