package jp.co.who.spring_tutorial.api.sample.controller;

import jp.co.who.spring_tutorial.api.sample.dto.JsonDataTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

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

    private final ApiWebclientService apiWebclientService;

    public ApiWebclientController(ApiWebclientService apiWebclientService) {
        this.apiWebclientService = apiWebclientService;
    }

    /**
     * リクエストの確認用
     */
    @PostMapping("test2")
    @ResponseBody
    public JsonDataTest test(@Validated JsonDataTest data) {
        Logger logger = LoggerFactory.getLogger(ApiWebclientController.class);
        logger.info("test: " + data.toString());
        var x = USER_AGENT;
        return data;
    }

    @PostMapping("test3")
    @ResponseBody
    public JsonDataTest test(@RequestBody JsonDataTest data, @RequestHeader(name = "User-Agent", required = false) String ua, HttpServletRequest request) {
        return apiWebclientService.createPrintResponse(data, ua, request);
    }

    @GetMapping("test")
    @ResponseBody
    public JsonDataTest getTest() {
        return apiWebclientService.test();
    }

    @Service
    public static class ApiWebclientService {

        private final ApiWebClientRepository apiWebClientRepository;

        public ApiWebclientService(ApiWebClientRepository apiWebClientRepository) {
            this.apiWebClientRepository = apiWebClientRepository;
        }

        public JsonDataTest createPrintResponse(JsonDataTest data, String ua, HttpServletRequest request) {
            Logger logger = LoggerFactory.getLogger(ApiWebclientController.class);
            logger.info("UA header: " + Optional.ofNullable(ua).map(Objects::toString).orElse("null"));
            logger.info("data: " + Optional.ofNullable(data).map(Objects::toString).orElse("null"));
            try {
                Cookie[] cookies = request.getCookies();
                for (var c : cookies) {
                    String message = String.format("cookie. name: %s, value: %s.", c.getName(), c.getValue());
                    logger.info(message);
                }
            } catch (Exception e) {
                logger.error("exception happenedd, while getting cookie. error = {}", e.getMessage(), e);
            }
            JsonDataTest.JsonDataChildren c = new JsonDataTest.JsonDataChildren("z", "kome");
            JsonDataTest jst = new JsonDataTest("ret", List.of(c));
            return jst;
        }

        public JsonDataTest test() {
            return apiWebClientRepository.test();
        }
    }

    @Repository
    public static class ApiWebClientRepository {

        private final WebClient wc;

        private final static String URL_BASE_PATH = "http://localhost:8080/";
        //final String URL_BASE_PATH = "http://192.168.123.123:8080/";

        public ApiWebClientRepository(WebClient wc) {
            this.wc = wc;
        }

        public JsonDataTest test() {
            JsonDataTest.JsonDataChildren c = new JsonDataTest.JsonDataChildren("y", "ame");
            JsonDataTest jst = new JsonDataTest("x", List.of(c));
            String uri = UriComponentsBuilder
                    .fromUriString(URL_BASE_PATH)
                    .path("api/webclient/test3")
                    .build()
                    .toUriString();
            return wc.post()
                    .uri(uri)
                    .contentType(APPLICATION_JSON)
                    //.cookie("cookie_name", "cookie_value")
                    .cookies(rCookies -> setCookies(rCookies))
                    .bodyValue(jst)
                    //.header(ACCEPT, APPLICATION_JSON_VALUE)
                    //.header(ACCEPT, TEXT_PLAIN_VALUE)
                    .accept(APPLICATION_JSON)
                    .header(USER_AGENT, "")
                    .retrieve()
                    .bodyToMono(JsonDataTest.class)
                    .onErrorResume(error -> {
                        Logger logger = LoggerFactory.getLogger(ApiWebclientController.class);
                        logger.warn("generic string: " + error.getClass().toGenericString());
                        logger.warn("cause: " + error.getLocalizedMessage());
                        logger.warn("message: " + error.getMessage());
                        logger.warn("message: " + error.getMessage(), error);
                        return Mono.error(new Exception(error.getMessage()));
                    })
                    .block();
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
}
