package jp.co.who.spring_tutorial.teratail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tyme")
public class TymeleafController {
    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("title", "タイトル");
        return "test";
    }
}
