package hello.crudpj.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.crudpj.model.entity.Comment;
import hello.crudpj.model.entity.QBoard;
import hello.crudpj.model.entity.QComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    private static final QComment comment = QComment.comment;
    public Comment find(Long commentNo, Long boardNo) {
        return queryFactory.select(comment)
                .from(comment)
                .where(comment.commentNo.eq(commentNo))
                .where(QBoard.board.boardNo.eq(boardNo))
                .fetchOne();
    }
}
