package board.crud.repository;

import board.crud.entity.Comment;
import board.crud.entity.CommentStatus;
import board.crud.entity.Post;
import board.crud.entity.PostStatus;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
@RequiredArgsConstructor
public class PostRepository {
    private final JpaPostRepository postRepository;

    // 1. 게시글 등록
    public Post save(Post post){
        return postRepository.save(post);
    }

    // 2. 게시글 삭제
    public void delete(Long id){
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을 수 없습니다."));

        if (existingPost.getPostStatus() == PostStatus.DELETED) {
            throw new IllegalStateException("삭제된 게시물입니다.");
        }
        // soft delete
        existingPost.setPostStatus(PostStatus.DELETED);
        // 해당 게시글에 속한 댓글들 삭제
        existingPost.getComments().forEach(comment -> comment.setCommentStatus(CommentStatus.DELETED));
    }

    // 3. 게시글 수정
    public Post update(Long id, Post post) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을 수 없습니다."));

        if (existingPost.getPostStatus() == PostStatus.DELETED) {
            throw new IllegalStateException("삭제된 게시물입니다.");
        }

        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        return existingPost;
    }

    // 4. 게시글 조회
    public Post findById(Long id) {
        Post findPost = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));

        if (findPost.getPostStatus() == PostStatus.DELETED) {
            throw new IllegalStateException("삭제된 게시물입니다.");
        }

        List<Comment> comments = findPost.getComments().stream()
                .filter(comment -> comment.getCommentStatus() != CommentStatus.DELETED)
                .collect(Collectors.toList());

        findPost.setComments(comments);
        return findPost;
    }

    // 5. 게시글 목록 조회 - 본문 포함 X
    public List<String> findAll(){
        List<Post> findPosts = postRepository.findAll();
        return findPosts.stream()
                .map(Post::getTitle)
                .collect(Collectors.toList());
    }

}
