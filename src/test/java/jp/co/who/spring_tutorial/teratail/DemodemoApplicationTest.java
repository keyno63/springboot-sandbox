package jp.co.who.spring_tutorial.teratail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(
        classes = SampleDomain.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public class DemodemoApplicationTest {
    @Autowired
    private SampleDomain domain;

    @MockBean
    private SampleInterface interDomain;

    @Test
    public void テスト1() {
    }
}
