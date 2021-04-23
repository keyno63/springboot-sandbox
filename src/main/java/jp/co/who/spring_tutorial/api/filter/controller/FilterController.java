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
        var serverNameObj = request.getAttribute("filter-server");
        String serverName = (String) serverNameObj;
        return new Response(z.getValue(), serverName);
    }

    @Getter
    private static class Response {

        @JsonProperty
        private final String value;

        @JsonProperty
        private final String serverName;

        public Response(String value, String serverName) {
            this.value = value;
            this.serverName = serverName;
        }
    }
}
