package com.board.model.request;

import lombok.Data;

@Data
public class BoardWriteRequest {
    private String title;
    private String body;
}
