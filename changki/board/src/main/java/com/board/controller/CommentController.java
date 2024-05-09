package com.board.controller;

import com.board.model.request.CommentPostRequest;
import com.board.model.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    @PostMapping("comment")
    public BoardResponse post(
            @RequestBody CommentPostRequest commentPostRequest
            ) {

    }
}
