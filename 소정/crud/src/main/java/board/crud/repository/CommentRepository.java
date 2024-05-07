package board.crud.repository;

import board.crud.entity.Comment;
import board.crud.entity.CommentStatus;
import board.crud.entity.Post;
import board.crud.entity.PostStatus;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class CommentRepository {
    private final JpaCommentRepository commentRepository;
    private final JpaPostRepository postRepository;

    // 1. 댓글 등록
    public Comment save(Long postId, Comment comment){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을 수 없습니다."));

        if (post.getPostStatus() == PostStatus.DELETED) {
            throw new IllegalStateException("삭제된 게시물입니다.");
        }

        comment.setPost(post);
        return commentRepository.save(comment);
    }

    // 2. 댓글 수정
    public Comment update(Long id, Comment comment){
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));

        if(existingComment.getCommentStatus() == CommentStatus.DELETED){
            throw new IllegalStateException("삭제된 댓글입니다.");
        }

        existingComment.setContent(comment.getContent());
        return existingComment;
    }

    // 3. 댓글 삭제
    public void delete(Long id){
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));

        if (existingComment.getCommentStatus() == CommentStatus.DELETED){
            throw new IllegalStateException("삭제된 댓글입니다.");
        }
        // soft delete
        existingComment.setCommentStatus(CommentStatus.DELETED);
    }
}
