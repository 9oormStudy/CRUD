package com.board.model.response;

import com.board.model.entity.Board;
import com.board.model.entity.BoardStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BoardResponse {

    private Long boardNo;
    private String title;
    private String body;
    private BoardStatus boardStatus;

    static public BoardResponse from(Board board) {
        return new BoardResponse(
                board.getBoardNo(),
                board.getTitle(),
                board.getBody(),
                board.getBoardStatus()
        );
    }
}
