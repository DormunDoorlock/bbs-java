package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;

import java.util.List;

public interface BoardService {
  Board findById(long id);

  List<Board> scanBoardList();

  void deleteById(long id);

  BoardEntity saveBoard(BoardEntity board);

  BoardEntity updateBoard(BoardEntity board, long id);

}