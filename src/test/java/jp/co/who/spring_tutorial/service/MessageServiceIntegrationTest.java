package jp.co.who.spring_tutorial.service;

import jp.co.who.spring_tutorial.config.MessageConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MessageConfig.class)
public class MessageServiceIntegrationTest {

    @InjectMocks
    MessageService service;

    //@Test
    public void メッセージバイコードの結合テスト() {
        System.out.println("start integration.");
        String actual = service.getMessageByCode("greeting");
        assertThat(actual, is("Hello!!"));
    }

    @Test
    public void hoge() {
        return;
    }
}
