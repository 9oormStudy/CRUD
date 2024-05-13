package com.board.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;
    private String body;
    @Enumerated(EnumType.STRING)
    private CommentStatus commentStatus;


}
