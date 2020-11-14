package jp.co.who.spring_tutorial.controller.api.sample;

import jp.co.who.spring_tutorial.controller.EchoController;
import jp.co.who.spring_tutorial.dto.JsonDataTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.USER_AGENT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Controller
@RequestMapping("/api/webclient")
public class ApiWebclientController {

    private final WebClient wc;

    public ApiWebclientController(WebClient wc) {
        this.wc = wc;
    }

    /**
     * リクエストの確認用
     */
    @PostMapping("test2")
    @ResponseBody
    public JsonDataTest test(@Validated JsonDataTest data) {
        Logger logger = LoggerFactory.getLogger(EchoController.class);
        logger.info("test: " + data.toString());
        var x = USER_AGENT;
        return data;
    }

    @PostMapping("test3")
    @ResponseBody
    public JsonDataTest test(@RequestBody JsonDataTest data, @RequestHeader(name = "User-Agent", required = false) String ua, HttpServletRequest request) {
        Logger logger = LoggerFactory.getLogger(EchoController.class);
        logger.info("UA header: " + Optional.ofNullable(ua).map(Objects::toString).orElse("null"));
        logger.info("data: " + Optional.ofNullable(data).map(Objects::toString).orElse("null"));
        Cookie[] cookies = request.getCookies();
        for (var c: cookies) {
            String message = String.format("cookie. name: %s, value: %s.", c.getName(), c.getValue());
            logger.info(message);
        }
        JsonDataTest.JsonDataChildren c = new JsonDataTest.JsonDataChildren("z", "kome");
        JsonDataTest jst = new JsonDataTest("ret", List.of(c));
        return jst;
    }

    @GetMapping("test")
    @ResponseBody
    public JsonDataTest getTest() {
        JsonDataTest.JsonDataChildren c = new JsonDataTest.JsonDataChildren("y", "ame");
        JsonDataTest jst = new JsonDataTest("x", List.of(c));
        //Mono<JsonDataTest> mjst = Mono.
        final String URL_BASE_PATH = "http://localhost:8080/";
        String uri = UriComponentsBuilder
                .fromUriString(URL_BASE_PATH)
                .path("api/webclient/test3")
                .build()
                .toUriString();
        JsonDataTest res = wc.post()
                .uri(uri)
                .contentType(APPLICATION_JSON)
                //.cookie("cookie_name", "cookie_value")
                .cookies(rCookies -> setCookies(rCookies))
                .bodyValue(jst)
                //.header(ACCEPT, APPLICATION_JSON_VALUE)
                //.header(ACCEPT, TEXT_PLAIN_VALUE)
                .accept(APPLICATION_JSON)
                .header(USER_AGENT)
                .retrieve()
                .bodyToMono(JsonDataTest.class)
                .block();
        return res;
    }

    private void setCookies(MultiValueMap<String, String> cookies) {
        cookies.setAll(
                Map.of(
                        "A", "a_cookie",
                        "X", "x_cookie"
                )
        );
    }
}
