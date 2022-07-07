package com.example.swcoaching.controller;

import com.example.swcoaching.board.PostService;
import com.example.swcoaching.board.jpa.PostEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping
@ResponseBody
public class PostController {

    private final PostService postService;

    @DeleteMapping("/posts/{postId}")
    public Long deletePost(@PathVariable long postId) {
        postService.deleteById(postId);
        return postId;
    }

    @PostMapping("/post/save/{boardId}")
    public Long savePost(
            @PathVariable long boardId,
            @RequestBody PostEntity postEntity)
    {
        return postService.savePost(boardId, postEntity);
    }
}
