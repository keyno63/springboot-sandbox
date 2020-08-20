package jp.co.who.spring_tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


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

    @RequestMapping(value="/search")
    public ModelAndView search(
            @RequestParam("key") String key, ModelAndView mv) {
        mv.setViewName("search");
        //List<OfuroEntity> list = repository.findByNameLike("%" + key + "%");
        //List<String> list = List.of("neo");
        List<String> list = new ArrayList<>();
        list.add("1");
        mv.addObject("list", list);
        return mv;
    }
}
