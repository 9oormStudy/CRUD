package board.crud.controller;

import board.crud.Service.CommentService;
import board.crud.entity.Comment;
import board.crud.entity.CommentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 1. 댓글 등록
    @PostMapping("/posts/{postId}/comment")
    public ResponseEntity<Comment> createComment(@PathVariable("postId") Long postId, @RequestBody Comment comment) {
        comment.setCommentStatus(CommentStatus.CREATED);
        Comment createdComment = commentService.createComment(postId, comment);
        return ResponseEntity.ok(createdComment);
    }

    // 2. 댓글 수정
    @PostMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable("id") Long id, @RequestBody Comment comment){
        Comment editComment = commentService.updateComment(id, comment);
        return ResponseEntity.ok(editComment);
    }

    // 3. 댓글 삭제
    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
