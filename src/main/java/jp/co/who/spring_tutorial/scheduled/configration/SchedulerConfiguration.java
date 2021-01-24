package jp.co.who.spring_tutorial.scheduled.configration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ConditionalOnProperty(prefix = "scheduler", name = "enabled", havingValue = "true")
public class SchedulerConfiguration {}
