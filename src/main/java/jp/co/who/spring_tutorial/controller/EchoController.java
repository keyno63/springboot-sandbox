package jp.co.who.spring_tutorial.controller;

import jp.co.who.spring_tutorial.dto.ResponseTest;
import jp.co.who.spring_tutorial.form.EchoForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/echo")
public class EchoController {

    @RequestMapping(method = RequestMethod.GET)
    public static String viewInput(Model model) {
        EchoForm form = new EchoForm();
        model.addAttribute(form);
        return "echo/input";
    }

    @RequestMapping(value = "echo_forward", method = RequestMethod.GET)
    public static String forward() {
        return "forward:/echo";
    }

    @RequestMapping(value = "json", method = RequestMethod.GET)
    public static String json() {
        return "json/sample.json";
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

}
