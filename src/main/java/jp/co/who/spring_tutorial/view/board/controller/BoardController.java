package jp.co.who.spring_tutorial.view.board.controller;

import jp.co.who.spring_tutorial.view.board.property.BoardConfigProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardConfigProperty boardConfigProperty;


    public BoardController(BoardConfigProperty boardConfigProperty) {
        this.boardConfigProperty = boardConfigProperty;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("sampleLink", boardConfigProperty.getSampleLink());
        return "board/home";
    }
}
