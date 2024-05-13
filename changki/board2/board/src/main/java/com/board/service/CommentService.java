package com.board.service;

import com.board.model.entity.Comment;
import com.board.model.entity.CommentStatus;
import com.board.model.response.BoardResponse;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;

    @PostMapping("comment")
    public BoardResponse writeComment(Long boardId, String commentBody) {
        return boardRepository.findById(boardId)
                .map(board -> board.addComment(commentBody))
                .map(boardRepository::save)
                .map(board -> BoardResponse.changeBoardResponse(board))
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글 입니다."));
    }
}
