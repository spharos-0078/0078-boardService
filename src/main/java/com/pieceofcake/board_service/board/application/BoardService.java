package com.pieceofcake.board_service.board.application;

import com.pieceofcake.board_service.board.dto.in.*;
import com.pieceofcake.board_service.board.dto.out.*;
import com.pieceofcake.board_service.board.domain.BoardType;

import java.util.List;

public interface BoardService {

    List<GetNoticeUuidResponseDto> getNoticeBoardUuidListByBoardType(BoardType boardType);

    List<GetEventUuidResponseDto> getEventBoardUuidListByBoardType(BoardType boardType);

    List<GetFaqUuidResponseDto> getFaqBoardUuidListByBoardType(BoardType boardType);

    GetNoticeResponseDto getNoticeBoardByBoardUuid(String boardUuid);

    GetEventResponseDto getEventBoardByBoardUuid(String boardUuid);

    GetFaqResponseDto getFaqBoardByBoardUuid(String boardUuid);

    void createCommunityBoard(CreateCommunityRequestDto createCommunityRequestDto);

    void createNotice(CreateNoticeRequestDto createNoticeRequestDto);

    void createEvent(CreateEventRequestDto createEventRequestDto);

    void createFaq(CreateFaqRequestDto createFaqRequestDto);

    void createSaleRequest(CreateSaleRequestDto createSaleRequestDto);

}
