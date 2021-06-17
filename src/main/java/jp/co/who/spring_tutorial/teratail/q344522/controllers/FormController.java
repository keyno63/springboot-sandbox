package jp.co.who.spring_tutorial.teratail.q344522.controllers;


import jp.co.who.spring_tutorial.teratail.q344522.entity.FormEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    private static final String BASE_PATH = "q344522";

    @GetMapping(BASE_PATH + "/entry")
    public String entry(Model model) {
        model.addAttribute("formEntity", new FormEntity());
        return String.format("t/%s/home", BASE_PATH);
    }

    @PostMapping(BASE_PATH + "/entry")
    @ResponseBody
    public FormEntity entryPost(@ModelAttribute FormEntity formEntity) {
        return formEntity;
    }
}
