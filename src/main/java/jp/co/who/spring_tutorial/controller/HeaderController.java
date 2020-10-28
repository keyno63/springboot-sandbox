package jp.co.who.spring_tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Header を制御する処理をまとめた Controller
 */
@RequestMapping("/header")
@Controller
public class HeaderController {

    @GetMapping("/userAgent")
    @ResponseBody
    public String userAgent(HttpServletRequest request) {
        return request.getHeader(HeaderValues.USER_AGENT);
    }

    @GetMapping("/cookie")
    @ResponseBody
    public String cookie(HttpServletRequest request) {
        return request.getHeader(HeaderValues.COOKIE);
    }

    private static class HeaderValues {
        private static final String USER_AGENT = "User-Agent";
        private static final String COOKIE = "Cookie";
    }
}
