package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.BoardRepository;
import com.example.swcoaching.board.jpa.PostEntity;
import com.example.swcoaching.board.jpa.PostRepository;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    private BoardRepository boardRepository;

    public PostServiceImpl(PostRepository postRepository,
                           BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public long savePost(Long id, PostEntity postEntity){
        // Foreign key 연계 어떻게?
        BoardEntity board = boardRepository.findById(id).get();
        postEntity.setBoard(board);
        return postRepository.save(postEntity).getId();
    }
}
