package hello.crudpj.controller;

import hello.crudpj.model.request.CommentDeleteRequest;
import hello.crudpj.model.request.CommentEditRequest;
import hello.crudpj.model.request.CommentPostRequest;
import hello.crudpj.model.response.BoardResponse;
import hello.crudpj.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("comment")
    public BoardResponse post(
            @RequestBody CommentPostRequest commentPostRequest
    ) {
        return commentService.postComment(commentPostRequest.getBoardNo(), commentPostRequest.getCommentBody());
    }

    @PutMapping("comment")
    public String edit(
            @RequestBody CommentEditRequest commentEditRequest
    ) {
        commentService.editComment(commentEditRequest.getBoardNo(), commentEditRequest.getCommentNo(), commentEditRequest.getCommentBody());

        return "OK";
    }

    @DeleteMapping("comment")
    public String delete(
            @RequestBody CommentDeleteRequest commentDeleteRequest
    ) {

        commentService.deleteComment(commentDeleteRequest.getBoardNo(), commentDeleteRequest.getCommentNo());

        return "OK";
    }
}

