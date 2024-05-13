package com.board.model.request;

import lombok.Data;

@Data
public class CommentWriteRequest {
    private Long boardId;
    private String body;
}
