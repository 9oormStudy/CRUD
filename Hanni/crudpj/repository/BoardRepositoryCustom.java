package hello.crudpj.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.crudpj.model.entity.Board;
import hello.crudpj.model.entity.QBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    private final static QBoard board = QBoard.board;

    public Optional<Board> find(Long boardNo) {
        return Optional.ofNullable(
                queryFactory.select(board)
                        .from(board)
                        .leftJoin(board.comments).fetchJoin()
                        .where(board.boardNo.eq(boardNo))
                        .fetchOne()
        );
    }
}
