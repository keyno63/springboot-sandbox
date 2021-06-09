package jp.co.who.spring_tutorial.teratail.q343030.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.springframework.stereotype.Controller;

@Controller
public class EngineController {

    private final SpringTemplateEngine springTemplateEngine;

    public EngineController(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @GetMapping("/api/template/engine")
    public String engine(
            Model model,
            @RequestParam(name = "pattern", defaultValue = "false") boolean pattern) {
        final String cssStructure = template(pattern);
        model.addAttribute("css", cssStructure);
        return "t/q343030/base_template";
    }

    private String template(boolean pattern) {
        final Context context = new Context();
        if (pattern) {
            context.setVariable("href", "something");
            return springTemplateEngine.process("t/q343030/pattern_1", context);
        }

        context.setVariable("href", "anything");
        return springTemplateEngine.process("t/q343030/pattern_2", context);
    }
}
