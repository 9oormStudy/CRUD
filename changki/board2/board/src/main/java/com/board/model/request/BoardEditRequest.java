package com.board.model.request;

import lombok.Data;

@Data
public class BoardEditRequest {
    private Long boardId;
    private String body;
}
