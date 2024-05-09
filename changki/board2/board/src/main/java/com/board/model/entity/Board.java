package com.board.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    private String title;
    private String body;
    @Enumerated(EnumType.STRING)
    private BoardStatus boardStatus;


}
