package jp.co.who.spring_tutorial.teratail.q341428.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MemberService {

    public Integer delayExport(List<String> memberList) {
        try {
            Thread.sleep(10000);
            log.info("finish sleep");
        } catch (Exception e) {
            log.info("exception");
            return 0;
        }
        return 1;
    }
}
