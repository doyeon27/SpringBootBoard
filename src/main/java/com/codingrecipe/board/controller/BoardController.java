package com.codingrecipe.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    // 버튼을 누르든 링크를 타든 요청방식은 GET
    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }
}
