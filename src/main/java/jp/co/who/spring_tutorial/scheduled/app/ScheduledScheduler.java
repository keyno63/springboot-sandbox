package jp.co.who.spring_tutorial.scheduled.app;

import jp.co.who.spring_tutorial.scheduled.service.ScheduledService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledScheduler {

    private final ScheduledService scheduledService;

    public ScheduledScheduler(ScheduledService scheduledService) {
        this.scheduledService = scheduledService;
    }

    @Scheduled(
            fixedRateString = "1000",
            initialDelayString = "1000"
    )
    public void exec() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            log.warn("failed", e);
        }

        scheduledService.exec();
    }
}
