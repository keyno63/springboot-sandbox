package jp.co.who.spring_tutorial;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleControllerRoot {

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @RequestMapping(value="/hello")
    public String hello() {
        return "hello";
    }
}

