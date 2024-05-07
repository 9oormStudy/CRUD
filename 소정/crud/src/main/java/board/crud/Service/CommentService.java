package board.crud.Service;

import board.crud.entity.Comment;
import board.crud.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository repository;

    // 1. 댓글 등록
    public Comment createComment(Long postId, Comment comment){
        return repository.save(postId, comment);
    }

    // 2. 댓글 수정
    public Comment updateComment(Long id, Comment comment){
        return repository.update(id, comment);
    }

    // 3. 댓글 삭제
    public void deleteComment(Long id){
        repository.delete(id);
    }
}
