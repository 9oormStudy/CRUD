package com.board.service;

import com.board.model.response.BoardResponse;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;

    public BoardResponse postComment(Long boardId, String commentBody) {
        boardRepository.findById(boardId)
                .map(board -> board.addComment(commentBody))
                .map(boardRepository::save)
                .map(BoardResponse::from)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));

    }
}
