package com.board.service;

import com.board.model.entity.Board;
import com.board.model.entity.BoardStatus;
import com.board.model.response.BoardResponse;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardResponse boardWrite(String title, String body) {
        Board board = new Board();
        board.setTitle(title);
        board.setBody(body);
        board.setBoardStatus(BoardStatus.ACTIVE);

        return BoardResponse.changeBoardResponse(boardRepository.save(board));
    }

    public BoardResponse boardEdit(Long boardId, String body) {
        return boardRepository.findById(boardId)
                .map(board -> {
                    board.setBody(body);
                    return BoardResponse.changeBoardResponse(board);
                })
//                .map(BoardResponse::changeBoardResponse)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글 입니다."));
    }

    public BoardResponse boardGet(Long boardId) {
        return boardRepository.findById(boardId)
                .map(BoardResponse::changeBoardResponse)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글 입니다."));
    }

    public List<BoardResponse> boardGetList() {
        return boardRepository.findAll()
                .stream().map(BoardResponse::changeBoardResponse)
                .toList();
    }
}
