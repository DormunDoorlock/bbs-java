package com.example.swcoaching.controller;

import com.example.swcoaching.board.Board;
import com.example.swcoaching.board.BoardService;
import com.example.swcoaching.board.jpa.BoardEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
public class IndexController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("boardList",boardService.scanBoardList());
        return "index";
    }

    @GetMapping("/posts/save/{boardId}")
    public String post_save(
            @PathVariable long boardId,
            Model model)
    {
        model.addAttribute("boardId",boardId);
        return "save";
    }
}
