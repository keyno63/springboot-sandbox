package jp.co.who.spring_tutorial.repository;

import jp.co.who.spring_tutorial.config.MessageConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MessageConfig.class)
public class MessageServiceIntegrationTest {

    @Autowired
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
