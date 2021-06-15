package jp.co.who.spring_tutorial.teratail.q344182.session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
@Getter
@Setter
public class SampleSession implements Serializable {
    private String id;
}
