package jp.co.who.spring_tutorial.controller;

import jp.co.who.spring_tutorial.form.EchoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


//@Slf4j
@Controller
@RequestMapping("/echo")
public class EchoController {

    public EchoController() {
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

//    @RequestMapping("json_re")
//    public static ResponseEntity<ResponseTest<Map<String, ? extends Object>>> jsonRe() {
//        List<Map<String, ? extends Object>> list = new ArrayList<>();
//        // data0
//        Map<String, Object> map0 = Map.of("path", "json_re");
//        list.add(map0);
//        // data1
//        Map<String, Object> map1 = Map.of("sample", "data");
//        list.add(map1);
//        // data2
//        Map<String, Object> map2 = Map.of(
//                "version", 1,
//                "source", "json",
//                "queue", false
//        );
//        Map<String, Map<String, Object>> map = Map.of("data", map2);
//        list.add(map);
//        var ret = List.of(
//                Map.of("path", "json_re"),
//                Map.of("sample", "data"),
//                Map.of("data", Map.of(
//                        "version", 1,
//                        "source", "json",
//                        "queue", false
//                ))
//        );
//
//        ResponseTest<Map<String, Map<String, ? extends Object>>> json = new ResponseTest<>();
//        json.setData(list);
//        return new ResponseEntity<ResponseTest<Map<String, ? extends Objects >>>(json, HttpStatus.OK);
//    }

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
