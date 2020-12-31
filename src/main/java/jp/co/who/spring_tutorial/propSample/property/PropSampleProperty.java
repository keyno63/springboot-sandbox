package jp.co.who.spring_tutorial.propSample.property;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties("app.sample")
public class PropSampleProperty {

    private final String url;
    private final int timeout;

    public PropSampleProperty(String url, int timeout) {
        this.url = url;
        this.timeout = timeout;
    }
}
