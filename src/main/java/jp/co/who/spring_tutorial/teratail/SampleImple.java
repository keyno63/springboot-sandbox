package jp.co.who.spring_tutorial.teratail;

import org.springframework.stereotype.Component;

@Component
public class SampleImple implements SampleInterface {

    @Override
    public boolean getTrue() {
        return true;
    }
}
