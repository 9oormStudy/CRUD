package hello.crudpj.model.response;

import hello.crudpj.model.entity.Board;
import hello.crudpj.model.entity.BoardStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class BoardResponse {
    private Long boardNo;
    private String title;
    private String body;
    private BoardStatus boardStatus;
    private List<CommentResponse> comments;

    static public BoardResponse from(Board board) {
        return new BoardResponse(
                board.getBoardNo(),
                board.getTitle(),
                board.getBody(),
                board.getBoardStatus(),
                board.getComments().stream().map(CommentResponse::from).collect(Collectors.toList())
        );
    }
}
