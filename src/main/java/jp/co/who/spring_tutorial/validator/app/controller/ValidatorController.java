package jp.co.who.spring_tutorial.validator.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController {

    @GetMapping("/validation")
    public String get() {
        return "";
    }
}
