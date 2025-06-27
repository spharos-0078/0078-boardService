package com.pieceofcake.board_service.ai.dto.out;

import com.pieceofcake.board_service.ai.dto.in.AiRequestDto;
import com.pieceofcake.board_service.ai.vo.out.AiResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@NoArgsConstructor
public class AiResponseDto {
    private String model;
    private String result;

    @Builder
    public AiResponseDto(String model, String result) {
        this.model = model;
        this.result = result;
    }

    public static AiResponseDto of(String model, String result) {
        return AiResponseDto.builder()
                .model(model)
                .result(result)
                .build();
    }

    public AiResponseVo toVo() {
        return AiResponseVo.builder()
                .model(model)
                .result(result)
                .build();
    }


    /**
     * 가격과 설명을 파싱해서 반환하는 커스텀 응답 변환기
     */
    public ParsedAiResult parseResult() {
        Pattern pattern = Pattern.compile("[\\d,]+\\.");
        Matcher matcher = pattern.matcher(result);

        String price = "";
        String description = "";

        if (matcher.find()) {
            price = matcher.group().replace(".", "").trim(); // 마침표 제거
            description = result.substring(matcher.end()).trim().replaceAll("^\"|\"$", ""); // 설명 부분
        }

        return new ParsedAiResult(price.replace(",", ""), description); // 쉼표 제거한 숫자
    }

    /**
     * 내부 응답 모델 - 게시판 생성 시 사용
     */
    @Getter
    @AllArgsConstructor
    public static class ParsedAiResult {
        private String estimatedPrice;
        private String estimatedDescription;
    }

    public Long getEstimatedPrice() {
        if (result == null) return null;

        // 숫자만 추출
        Pattern pattern = Pattern.compile("(\\d{1,3}(,\\d{3})*|\\d+)");
        Matcher matcher = pattern.matcher(result);

        if (matcher.find()) {
            String numeric = matcher.group().replaceAll(",", "");
            return Long.parseLong(numeric);
        }

        return null;
    }

    public String getDescription() {
        if (result == null) return null;

        int dotIndex = result.indexOf(".");
        if (dotIndex == -1 || dotIndex + 1 >= result.length()) return "";

        return result.substring(dotIndex + 1).trim();
    }
}
