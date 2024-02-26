package com.codingrecipe.board.controller;

import com.codingrecipe.board.dto.BoardDto;
import com.codingrecipe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    // 버튼을 누르든 링크를 타든 요청방식은 GET
    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDto boardDto) {
        System.out.println("boardDto = " + boardDto);
        boardService.save(boardDto);

        return "index";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        // DB 에서 전체 게시글 데이터를 가져와서 list.html 에 보여줌
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        /*
            해당 게시글의 조회수를 하나 올리고
            게시글 데이터를 가져와서 detail.html 에 출력
         */
        boardService.updateHits(id);
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("boardUpdate", boardDto);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDto boardDto, Model model) {
        BoardDto board = boardService.update(boardDto);
        model.addAttribute("board", board);
        return "detail";
//        return "redirect:/board/" + boardDto.getId();  // 조회 수 영향?
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.delete(id);
        return "redirect:/board/";
    }



//    // import org.springframework.data.domain.Pageable; 임포트 이거 해야함, Pageable
//    // 페이징 요청이 올때, /board/paging?page=1 이런 식으로
//    @GetMapping("/paging")
//    public String paging(@PageableDefault(page = 1) Pageable pageable, Model model){
////        pageable.getPageNumber();
//        Page<BoardDto> boardList = boardService.paging(pageable);
//
//
//    }

}
