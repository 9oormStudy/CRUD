package com.board.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();

    public Board addComment(String commentBody) {
        Comment comment = new Comment();
        comment.setBody(commentBody);
        comment.setBoard(this);
        comment.setCommentStatus(CommentStatus.ACTIVE);
        this.comments.add(comment);
        return this;
    }


}
