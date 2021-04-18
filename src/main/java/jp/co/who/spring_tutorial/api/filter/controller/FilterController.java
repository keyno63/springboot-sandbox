package jp.co.who.spring_tutorial.api.filter.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/filter")
public class FilterController {

    @GetMapping("/header")
    public Response header(HttpServletRequest request) {
        var x = request.getAttribute("new-cookie");
        Cookie z = (Cookie) x;
        return new Response(z.getValue());
    }

    @Getter
    private static class Response {

        @JsonProperty
        private final String value;

        public Response(String value) {
            this.value = value;
        }
    }
}
