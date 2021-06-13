package jp.co.who.spring_tutorial.teratail.q313205;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/any/question")
public class HelloController {

    @RequestMapping
    public ModelAndView hello() {
        return new ModelAndView("t/q313205/hello");
    }
}
