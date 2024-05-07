package com.board.controller;

import com.board.model.request.BoardDeleteRequest;
import com.board.model.request.BoardEditRequest;
import com.board.model.request.BoardWriteRequest;
import com.board.model.response.BoardResponse;
import com.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("board")
    public BoardResponse writeBoard(@RequestBody BoardWriteRequest boardWriteRequest) {
        return boardService.writeBoard(boardWriteRequest.getTitle(), boardWriteRequest.getBody());
    }

    @PutMapping("board")
    public BoardResponse editBoard(@RequestBody BoardEditRequest boardEditRequest) {
        return boardService.editBoard(boardEditRequest.getBoardNo(), boardEditRequest.getBody());
    }

    @DeleteMapping("board")
    public Long deleteBoard(@RequestBody BoardDeleteRequest boardDeleteRequest) {
        return boardService.deleteBoard(boardDeleteRequest.getBoardNo());

    }
}
