package hello.crudpj.service;

import hello.crudpj.model.entity.Comment;
import hello.crudpj.model.response.BoardResponse;
import hello.crudpj.repository.BoardRepository;
import hello.crudpj.repository.BoardRepositoryCustom;
import hello.crudpj.repository.CommentRepository;
import hello.crudpj.repository.CommentRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final BoardRepository boardRepository;
    private final BoardRepositoryCustom boardRepositoryCustom;
    private final CommentRepositoryCustom commentRepositoryCustom;
    private final CommentRepository commentRepository;


    public BoardResponse postComment(Long boardId, String commentBody) {
        return boardRepositoryCustom.find(boardId)
                .map(board -> board.addComment(commentBody))
                .map(boardRepository::save)
                .map(BoardResponse::from)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));
    }

    public void editComment(Long boardNo, Long commentNo, String commentBody) {
        Comment comment = commentRepositoryCustom.find(commentNo, boardNo);
        if(comment == null) throw new RuntimeException("존재하지 않는 댓글입니다.");
        comment.setBody(commentBody);
    }

    public void deleteComment(Long boardNo, Long commentNo) {
        Comment comment = commentRepositoryCustom.find(commentNo, boardNo);
        if(comment == null) throw new RuntimeException("존재하지 않는 댓글입니다.");
        commentRepository.delete(comment);
    }
}
