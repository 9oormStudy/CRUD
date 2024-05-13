package com.board.model.response;

import com.board.model.entity.Board;
import com.board.model.entity.BoardStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BoardResponse {
    private Long boardId;
    private String title;
    private String body;
    private BoardStatus boardStatus;
//    private List<CommentResponse> comments;


/*    public BoardResponse(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.body = board.getBody();
        this.boardStatus = board.getBoardStatus();
    }

    public BoardResponse changBoardResponse() {
        return new BoardResponse(boardId, title, body, boardStatus);
    }*/

    public static BoardResponse changeBoardResponse(Board board) {
        return new BoardResponse(
                board.getBoardId(),
                board.getTitle(),
                board.getBody(),
                board.getBoardStatus()
//                board.getComments().stream().map
        );
    }

}
