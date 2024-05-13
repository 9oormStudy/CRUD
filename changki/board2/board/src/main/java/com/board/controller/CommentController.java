package com.board.controller;

import com.board.model.request.CommentWriteRequest;
import com.board.model.response.BoardResponse;
import com.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("comment")
    public BoardResponse writeComment(@RequestBody CommentWriteRequest commentWriteRequest) {
        return commentService.writeComment(commentWriteRequest.getBoardId(), commentWriteRequest.getBody());
    }

    @PutMapping("comment")
    public void editComment() {

    }

    @DeleteMapping("comment")
    public void deleteComment() {
    }


    /*    @GetMapping("comment")
    public void getComment() {

    }

    @GetMapping("commentList")
    public void getListComment() {
    }*/



}
