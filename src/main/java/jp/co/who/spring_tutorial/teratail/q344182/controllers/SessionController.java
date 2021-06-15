package jp.co.who.spring_tutorial.teratail.q344182.controllers;

import jp.co.who.spring_tutorial.teratail.q344182.session.SampleSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    private final SampleSession sampleSession;

    public SessionController(SampleSession sampleSession) {
        this.sampleSession = sampleSession;
    }

    @GetMapping("/q344182/session1")
    public String session1(@RequestParam("name") String name) {
        sampleSession.setId(name);
        return "ok";
    }

    @GetMapping("/q344182/session2")
    public String session2() {
        return sampleSession.getId();
    }
}
