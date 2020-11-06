package jp.co.who.spring_tutorial.controller;

import jp.co.who.spring_tutorial.dto.JsonDataTest;
import jp.co.who.spring_tutorial.dto.ResponseTest;
import jp.co.who.spring_tutorial.form.EchoForm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.MediaType.*;

//@Slf4j
@Controller
@RequestMapping("/echo")
public class EchoController {

    private final WebClient wc;

    public EchoController(WebClient wc) {
        this.wc = wc;
    }

    @RequestMapping(method = RequestMethod.GET)
    public static String viewInput(Model model) {
        EchoForm form = new EchoForm();
        model.addAttribute(form);
        return "echo/input";
    }

    @RequestMapping(method = RequestMethod.POST)
    public static String viewOutput(EchoForm form) {
        return "echo/output";
    }

    @RequestMapping(value = "echo_forward", method = RequestMethod.GET)
    public static String forward() {
        return "forward:/echo";
    }

    @RequestMapping(value = "json", method = RequestMethod.GET)
    public static String json() {
        return "json/sample.json";
    }

    @RequestMapping(value = "easy", method = RequestMethod.GET)
    @ResponseBody
    public static Map<String, String> easy() {
        Map<String, String> map = new HashMap<>();
        map.put("version", "1");
        map.put("user", "user1");
        return map;
    }

    @RequestMapping("json_re")
    public static ResponseEntity<ResponseTest<Map>> jsonRe() {
        List<Map> list = new ArrayList<>();
        // data0
        Map<String, String> map0 = new HashMap<>();
        map0.put("path", "json_re");
        list.add(map0);
        // data1
        Map<String, String> map1 = new HashMap<>();
        map1.put("sample", "data");
        list.add(map1);
        // data2
        Map<String, Object> map2 = new HashMap<>();
        map2.put("version", 1);
        map2.put("source", "json");
        map2.put("queue", false);
        Map<String, Map> map = new HashMap<>();
        map.put("data", map2);
        list.add(map);

        ResponseTest<Map> json = new ResponseTest<>();
        json.setData(list);
        return new ResponseEntity<ResponseTest<Map>>(json, HttpStatus.OK);
    }

    @PostMapping("post")
    @ResponseBody
    public static Map<String, Object> post() {
        Map<String, Object> map = new HashMap<>();
        map.put("version", 1);
        map.put("value", "get");
        map.put("request", "put");
        return map;
    }

    /**
     * リクエストの確認用
     */
    @PostMapping("test2")
    @ResponseBody
    public JsonDataTest test(@Validated JsonDataTest data) {
        Logger logger = LoggerFactory.getLogger(EchoController.class);
        logger.info("xxxxx: " + data.toString());
        return data;
    }

    @PostMapping("test3")
    @ResponseBody
    public JsonDataTest test(String data) {
        Logger logger = LoggerFactory.getLogger(EchoController.class);
        logger.info("xxxxx: " + Optional.ofNullable(data).map(Objects::toString).orElse("null"));
        JsonDataTest.JsonDataChildren c = new JsonDataTest.JsonDataChildren("z", "kome");
        JsonDataTest jst = new JsonDataTest("ret", List.of(c));
        return jst;
    }

    @GetMapping("test")
    @ResponseBody
    public JsonDataTest getTest() {
        JsonDataTest.JsonDataChildren c = new JsonDataTest.JsonDataChildren("y", "ame");
        JsonDataTest jst = new JsonDataTest("x", List.of(c));
        JsonDataTest res = wc.post()
                .uri("http://localhost:8080/echo/test3")
                .bodyValue(jst)
                //.header(ACCEPT, APPLICATION_JSON_VALUE)
                .header(ACCEPT, TEXT_PLAIN_VALUE)
                .retrieve()
                .bodyToMono(JsonDataTest.class)
                .block();
        return res;
    }
}
