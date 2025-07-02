package com.pieceofcake.board_service.common.util;

import com.pieceofcake.board_service.common.entity.BaseResponseStatus;
import com.pieceofcake.board_service.common.exception.BaseException;
import org.springframework.util.StringUtils;

import java.util.List;

public class ValidationUtil {
    
    /**
     * 문자열이 null이거나 빈 문자열인지 검증
     */
    public static void validateNotBlank(String value, String fieldName) {
        if (!StringUtils.hasText(value)) {
            throw new BaseException(BaseResponseStatus.INVALID_INPUT);
        }
    }
    
    /**
     * 문자열 길이 검증
     */
    public static void validateStringLength(String value, String fieldName, int minLength, int maxLength) {
        if (value == null || value.length() < minLength || value.length() > maxLength) {
            throw new BaseException(BaseResponseStatus.INVALID_INPUT);
        }
    }
    
    /**
     * 가격 검증 (1원 이상, 999,999,999원 이하)
     */
    public static void validatePrice(Long price, String fieldName) {
        if (price == null || price < 1 || price > 999999999) {
            throw new BaseException(BaseResponseStatus.INVALID_DESIRED_PRICE);
        }
    }
    
    /**
     * AI 예측 가격 검증 (0원 이상, 999,999,999원 이하)
     */
    public static void validateAiEstimatedPrice(Long price, String fieldName) {
        if (price == null || price < 0 || price > 999999999) {
            throw new BaseException(BaseResponseStatus.INVALID_AI_ESTIMATED_PRICE);
        }
    }
    
    /**
     * 리스트 크기 검증
     */
    public static void validateListSize(List<?> list, String fieldName, int maxSize) {
        if (list != null && list.size() > maxSize) {
            throw new BaseException(BaseResponseStatus.INVALID_BOARD_IMAGE_COUNT);
        }
    }
    
    /**
     * URL 형식 검증 (간단한 검증)
     */
    public static void validateUrl(String url, String fieldName) {
        if (url == null || !url.startsWith("http")) {
            throw new BaseException(BaseResponseStatus.INVALID_BOARD_IMAGE_URL);
        }
    }
} 