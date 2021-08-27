package jp.co.who.spring_tutorial.api.stream.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Slf4j
@Component
public class AsyncHelper {

    @Async
    public void streaming(ResponseBodyEmitter emitter) throws Exception {
        log.debug("Start Async processing.");

        var max = 10;
        for (long i = 0; i < max; i ++) {
            Thread.sleep(1000);
            emitter.send(String.format("response. num: %d", i));
        }
        emitter.complete();

        log.debug("End Async processing.");
    }
}
