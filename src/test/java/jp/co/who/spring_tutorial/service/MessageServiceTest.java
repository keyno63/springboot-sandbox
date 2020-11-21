package jp.co.who.spring_tutorial.service;

import jp.co.who.spring_tutorial.api.message.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {
    @InjectMocks
    MessageService service;
    @Mock
    MessageSource mockSource;

    @Test
    public void メッセージ取得() {
        doReturn("Hello!!").when(mockSource)
                .getMessage("greeting", null, Locale.getDefault());


        String actual = service.getMessageByCode("greeting");
        assertThat(actual, is("Hello!!"));

    }
}