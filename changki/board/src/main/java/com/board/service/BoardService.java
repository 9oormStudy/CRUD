package com.board.service;


import com.board.model.entity.Board;
import com.board.model.entity.BoardStatus;
import com.board.model.response.BoardResponse;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardResponse writeBoard(String title, String body) {
        Board board = new Board();
        board.setTitle(title);
        board.setBody(body);
        board.setBoardStatus(BoardStatus.ACTIVE);
        return BoardResponse.from(boardRepository.save(board));
    }


    public BoardResponse editBoard(Long boardNo, String body) {
        return boardRepository.findById(boardNo)
                .map(board -> {
                    board.setBody(body);
                    return board;
                }).map(BoardResponse::from)
                .orElseThrow(() ->new RuntimeException("존재하지 않는 게시글 입니다.")) ;

    }

    public Long deleteBoard(Long boardNo) {
        return boardRepository.findById(boardNo)
                .map(board -> {
                    boardRepository.delete(board);
                    return board.getBoardNo();
                })
                .orElseThrow(() ->new RuntimeException("존재하지 않는 게시글 입니다.")) ;
    }
}
