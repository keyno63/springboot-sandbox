package jp.co.who.spring_tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Header を制御する処理をまとめた Controller
 */
@RequestMapping("/header")
@Controller
public class HeaderController {

    @GetMapping("/userAgent")
    @ResponseBody
    public String userAgent(@RequestHeader(HeaderValues.USER_AGENT) String value) {
        return value;
    }

    @GetMapping("/cookie")
    @ResponseBody
    public String cookie(@RequestHeader(HeaderValues.COOKIE) String value) {
        return value;
    }

    private static class HeaderValues {
        private static final String USER_AGENT = "User-Agent";
        private static final String COOKIE = "Cookie";
    }
}
