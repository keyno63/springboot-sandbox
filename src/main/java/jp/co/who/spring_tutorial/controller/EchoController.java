package jp.co.who.spring_tutorial.controller;

import jp.co.who.spring_tutorial.dto.JsonDataTest;
import jp.co.who.spring_tutorial.dto.ResponseTest;
import jp.co.who.spring_tutorial.form.EchoForm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.USER_AGENT;
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
}
