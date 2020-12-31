package jp.co.who.spring_tutorial.propSample.app.component;

import jp.co.who.spring_tutorial.propSample.property.PropSampleProperty;
import org.springframework.stereotype.Component;

@Component
public class PropComponent {

    private final PropSampleProperty propSampleProperty;

    public PropComponent(PropSampleProperty propSampleProperty) {
        this.propSampleProperty = propSampleProperty;
    }

    public String getUrl() {
        return propSampleProperty.getUrl();
    }

    public int getTimeout() {
        return propSampleProperty.getTimeout();
    }
}
