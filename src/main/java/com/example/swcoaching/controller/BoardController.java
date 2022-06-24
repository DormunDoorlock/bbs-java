package com.example.swcoaching.controller;

import com.example.swcoaching.board.Board;
import com.example.swcoaching.board.BoardService;
import com.example.swcoaching.board.jpa.BoardEntity;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
public class BoardController {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final BoardService boardService;

  @GetMapping("/board/{boardId}")
  public Board getBoard(@PathVariable long boardId) {
    Board board = boardService.findById(boardId);
    logger.info("Board: {}", board);
    return board;
  }

  @GetMapping("/board")
  public List<Board> scanBoard(){
    return boardService.scanBoardList();
  }

  @DeleteMapping("/board/{boardId}")
  public String deleteBoard(@PathVariable long boardId) {
    boardService.deleteById(boardId);
    return "Delete Success";
  }

  @PostMapping("/board")
  public BoardEntity saveBoard(@RequestBody BoardEntity boardEntity){
    return boardService.saveBoard(boardEntity);
  }
}