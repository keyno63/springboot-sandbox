package jp.co.who.spring_tutorial.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/param")
public class ParamController {

    @GetMapping
    public String get(@RequestParam(name = "param1", defaultValue = "") String param1,
                      @RequestParam(name = "param2", defaultValue = "") String param2)
    {
        return buildString("Get", Arrays.asList(param1, param2));
    }

    @PostMapping
    public String post(@RequestParam(name = "param1", defaultValue = "") String param1,
                       @RequestParam(name = "param2", defaultValue = "") String param2)
    {
        return buildString("Post", Arrays.asList(param1, param2));
    }

    @PutMapping
    public String put(@RequestParam(name = "param1", defaultValue = "") String param1,
                      @RequestParam(name = "param2", defaultValue = "") String param2)
    {
        return buildString("Put", Arrays.asList(param1, param2));
    }

    private String buildString(String name, List<String> params) {
        StringBuilder s = new StringBuilder();

        int c = 1;
        for (String param: params) {
            if (s.length() > 0)
                s.append(",");
            s.append(String.format("%s=%s", "param" + c, param));
            c += 1;
        }

        return String.format("%s: %s", name, s.toString());
    }
}



