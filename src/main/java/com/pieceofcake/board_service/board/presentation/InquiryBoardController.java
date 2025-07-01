package com.pieceofcake.board_service.board.presentation;

import com.pieceofcake.board_service.board.application.BoardService;
import com.pieceofcake.board_service.board.dto.in.CreateNormalRequestDto;
import com.pieceofcake.board_service.board.dto.in.CreateSaleRequestDto;
import com.pieceofcake.board_service.board.dto.out.GetMyNormalResponseDto;
import com.pieceofcake.board_service.board.dto.out.GetMySaleResponseDto;
import com.pieceofcake.board_service.board.dto.out.GetMySaleUuidResponseDto;
import com.pieceofcake.board_service.board.vo.in.CreateNormalRequestVo;
import com.pieceofcake.board_service.board.vo.in.CreateSaleRequestVo;
import com.pieceofcake.board_service.board.vo.out.GetMyNormalResponseVo;
import com.pieceofcake.board_service.board.vo.out.GetMySaleResponseVo;
import com.pieceofcake.board_service.board.vo.out.GetMySaleUuidResponseVo;
import com.pieceofcake.board_service.common.entity.BaseResponseEntity;
import com.pieceofcake.board_service.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@RestController
public class InquiryBoardController {

    private final BoardService boardService;

    // @GetMapping("/normal/admin") -> 일반 문의 전체 조회 (관리자 인증)
    // @GetMapping("/normal/admin/{boardUuid}") -> 일반 문의 상세 조회 (관리자 인증)

    // @GetMapping("/sale/admin") -> 판매 문의 전체 조회 (관리자 인증)
    // @GetMapping("/sale/admin/{boardUuid}") -> 판매 문의 상세 조회 (관리자 인증)

    @Operation(summary = "일반 문의 생성")
    @PostMapping("/normal")
    public BaseResponseEntity<Void> createNormalRequest(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody CreateNormalRequestVo createNormalRequestVo
    ) {
        boardService.createNormalRequest(CreateNormalRequestDto.from(memberUuid, createNormalRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "사용자 본인의 일반 문의 UUID 리스트 조회")
    @GetMapping("/normal/uuid-list/user")
    public BaseResponseEntity<List<GetMySaleUuidResponseVo>> getMyNormalRequestUuidList(
            @RequestHeader("X-Member-Uuid") String memberUuid
    ) {
        List<GetMySaleUuidResponseVo> uuidList = boardService.getNormalBoardUuidListByMemberUuid(memberUuid)
                .stream().map(GetMySaleUuidResponseDto::toVo).toList();
        return new BaseResponseEntity<>(uuidList);
    }

    @Operation(summary = "사용자 본인 일반 문의 상세 조회")
    @GetMapping("/normal/user/{boardUuid}")
    public BaseResponseEntity<GetMyNormalResponseVo> getNormalDetail(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @PathVariable String boardUuid
    ) {
        GetMyNormalResponseDto normalDetail = boardService
                .getMyNormalDetailByMemberUuidAndBoardUuid(memberUuid, boardUuid);
        return new BaseResponseEntity<>(normalDetail.toVo());
    }


    @Operation(summary = "사용자 본인의 판매 문의 UUID 리스트 조회")
    @GetMapping("/sale/uuid-list/user")
    public BaseResponseEntity<List<GetMySaleUuidResponseVo>> getMySaleRequestUuidList(
            @RequestHeader("X-Member-Uuid") String memberUuid
    ) {
        List<GetMySaleUuidResponseVo> uuidList = boardService.getSaleBoardUuidListByMemberUuid(memberUuid)
                .stream().map(GetMySaleUuidResponseDto::toVo).toList();
        return new BaseResponseEntity<>(uuidList);
    }

    @Operation(summary = "사용자 본인 판매 문의 상세 조회")
    @GetMapping("/sale/user/{boardUuid}")
    public BaseResponseEntity<GetMySaleResponseVo> getMySaleDetail(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @PathVariable String boardUuid
    ) {
        GetMySaleResponseDto salesDetail = boardService
                .getMySaleDetailByMemberUuidAndBoardUuid(memberUuid, boardUuid);
        return new BaseResponseEntity<>(salesDetail.toVo());
    }


    @Operation(summary = "판매 문의 생성")
    @PostMapping("/sale")
    public BaseResponseEntity<Void> createSaleRequest(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody CreateSaleRequestVo createSaleRequestVo
    ) {
        boardService.createSaleRequest(CreateSaleRequestDto.from(memberUuid, createSaleRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    // @PutMapping("/sale/{boardUuid}") -> 판매 문의 수정 (사용자 본인 확인)
    // @DeleteMapping("/sale/{boardUuid}") -> 판매 문의 삭제 (사용자 본인 확인)

    // @PutMapping("/normal/{boardUuid}") -> 일반 문의 수정 (사용자 본인 확인)
    // @DeleteMapping("/normal/{boardUuid}") -> 일반 문의 삭제 (사용자 본인 확인)

}
