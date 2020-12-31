package jp.co.who.spring_tutorial.view.board.property;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties("app.view.board")
public class BoardConfigProperty {
    private final String sampleLink;

    public BoardConfigProperty(String sampleLink) {
        this.sampleLink = sampleLink;
    }
}
