package jp.co.who.spring_tutorial.api.message.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {
    @InjectMocks
    MessageService service;
    @Mock
    MessageSource mockSource;

    @Test
    void メッセージ取得() {
        doReturn("Hello!!").when(mockSource)
                .getMessage("greeting", null, Locale.getDefault());


        String actual = service.getMessageByCode("greeting");
        //assertThat(actual, is("Hello!!"));
        assertThat(actual).isEqualTo("Hello!!");
    }
}