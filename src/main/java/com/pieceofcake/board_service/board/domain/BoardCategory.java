package com.pieceofcake.board_service.board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BoardCategory {
    FUNDING,
    PIECE,
    PRODUCT,
    AUCTION,
    OTHERS
}
