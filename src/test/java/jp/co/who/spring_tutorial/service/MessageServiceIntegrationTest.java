package jp.co.who.spring_tutorial.service;

import jp.co.who.spring_tutorial.api.message.repository.MessageRepository;
import jp.co.who.spring_tutorial.api.message.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class MessageServiceIntegrationTest {

    @Mock
    MessageSource messageSource;

    @Mock
    MessageRepository messageRepository;

    @InjectMocks
    MessageService service;

    @BeforeEach
    public void setUp() {
        doReturn("Hello!!")
                .when(messageSource)
                .getMessage(anyString(), any(), any());
    }

    @Test
    public void メッセージバイコードの結合テスト() {
        System.out.println("start integration.");
        String actual = service.getMessageByCode("greeting");
        assertThat(actual).isEqualTo( "Hello!!");
    }

    @Test
    public void hoge() {
        assertThat(true).isTrue();
    }
}
