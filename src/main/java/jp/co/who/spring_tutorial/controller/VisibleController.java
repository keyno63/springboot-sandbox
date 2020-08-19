package jp.co.who.spring_tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisibleController {

    @GetMapping("/")
    public String index(){
        return "sample/index";
    }

    @GetMapping("/index")
    public  String home(){
        return "sample/home";
    }
}
