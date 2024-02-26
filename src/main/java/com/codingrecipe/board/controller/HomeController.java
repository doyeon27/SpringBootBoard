package com.codingrecipe.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "first";
    }

    @GetMapping("/first.html")
    public String homePage() {
        return "first";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/index2")
    public String indexPage2() {
        return "index2";
    }




}
