package jp.co.who.spring_tutorial.scheduled.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScheduledServiceImpl implements ScheduledService {

    @Override
    public void exec() {
        log.info("called exec function.");
    }
}
