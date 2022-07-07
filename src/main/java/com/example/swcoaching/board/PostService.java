package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.PostEntity;

import java.util.List;

public interface PostService {

    void deleteById(long id);

    long savePost(Long id, PostEntity postEntity);
}
