package jp.co.who.spring_tutorial.controller.api.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * Header を制御する処理をまとめた Controller
 */
@RequestMapping("/api/header")
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

    @GetMapping("/contentType")
    @ResponseBody
    public String contentType(@RequestHeader(HeaderValues.CONTENT_TYPE) String value) {
        return value;
    }

    @GetMapping("/original")
    @ResponseBody
    public String original(@RequestHeader(HeaderValues.ORIGINAL) String value) {
        if (Objects.isNull(value)) {
            return "nothing header";
        }
        return value;
    }

    private static class HeaderValues {
        private static final String USER_AGENT = "User-Agent";
        private static final String COOKIE = "Cookie";
        private static final String CONTENT_TYPE = "Content-Type";
        private static final String ORIGINAL = "Original";
    }
}
