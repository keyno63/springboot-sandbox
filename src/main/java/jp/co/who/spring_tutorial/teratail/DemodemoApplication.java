package jp.co.who.spring_tutorial.teratail;

import org.springframework.stereotype.Service;

@Service
public class DemodemoApplication {

    private final SampleDomain domain;

    private final SampleInterface interDomain;

    DemodemoApplication(SampleDomain domain
            , SampleInterface interDomain
    ) {
        this.domain = domain;
        this.interDomain = interDomain;
    }

    public boolean get() {
        return domain.getTrue() && interDomain.getTrue();
    }

}
