package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;

  public BoardServiceImpl(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  // 단건 조회
  @Override
  @Transactional(readOnly = true)
  public Board findById(long id) {
    return boardRepository.findById(id)
            .map(Board::of)
            .orElseThrow(() -> new BoardNotFoundException(id));
  }

  // 전체 조회
  @Override
  public List<Board> scanBoardList(){
    Iterable<BoardEntity> boardList = boardRepository.findAll();
    List<Board> boardList1 = new ArrayList<>();
    Iterator<BoardEntity> iter = boardList.iterator();
    while (iter.hasNext()) {
      boardList1.add(Board.of(iter.next()));
    }
    return boardList1;
  }
/*
  // 단건 삭제
  @Override
  public void deleteById(long id) {
    boardRepository.deleteById(id);
  }

  // 단건 삽입
  @Override
  public BoardEntity saveBoard(BoardEntity boardEntity){
    return boardRepository.save(boardEntity);
  }

  @Override
  public BoardEntity updateBoard(BoardEntity boardEntity, long id){
    BoardEntity boardEntity1 = boardRepository.findById(id).get();
    if (Objects.nonNull(boardEntity.getTitle()) && !"".equalsIgnoreCase(boardEntity.getTitle())){
      boardEntity1.setTitle(boardEntity.getTitle());
    }
    if (Objects.nonNull(boardEntity.getRemark()) && !"".equalsIgnoreCase(boardEntity.getRemark())){
      boardEntity1.setRemark(boardEntity.getRemark());
    }
    return  boardRepository.save(boardEntity1);
  }
 */
}