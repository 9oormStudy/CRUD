package com.board.controller;

import com.board.model.request.BoardEditRequest;
import com.board.model.request.BoardGetRequest;
import com.board.model.request.BoardWriteRequest;
import com.board.model.response.BoardResponse;
import com.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("board")
    public BoardResponse boardWrite(@RequestBody BoardWriteRequest boardWriteRequest) {
        return boardService.boardWrite( boardWriteRequest.getTitle(), boardWriteRequest.getBody());
    }

    @PutMapping("board")
    public BoardResponse boardEdit(@RequestBody BoardEditRequest boardEditRequest) {
        return boardService.boardEdit(boardEditRequest.getBoardId(), boardEditRequest.getBody());
    }

    @GetMapping("board")
    public BoardResponse boardGet(@RequestParam("boardId") Long boardId) {
        return boardService.boardGet(boardId);
    }

    @GetMapping("boardList")
    public List<BoardResponse> boardGetList() {
        return boardService.boardGetList();
    }
}
