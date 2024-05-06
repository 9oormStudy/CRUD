package board.crud.controller;

import board.crud.Service.PostService;
import board.crud.entity.Comment;
import board.crud.entity.CommentStatus;
import board.crud.entity.Post;
import board.crud.entity.PostStatus;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 1. 게시글 등록
    @PostMapping("/post")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        post.setPostStatus(PostStatus.CREATED);
        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    // 2. 게시글 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    // 3. 게시글 수정
    @PostMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post editPost = postService.updatePost(id, post);
        return ResponseEntity.ok(editPost);
    }

    // 4. 게시글 조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id) {
        Post findPost = postService.getPostById(id);
        return ResponseEntity.ok(findPost);
    }

    // 5. 게시글 목록 조회
    @GetMapping("/posts")
    public ResponseEntity<List<String>> updatePost() {
        List<String> allPosts = postService.getAllPosts();
        return ResponseEntity.ok(allPosts);
    }
}
