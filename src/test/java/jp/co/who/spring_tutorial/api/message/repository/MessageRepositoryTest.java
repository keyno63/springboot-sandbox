package jp.co.who.spring_tutorial.api.message.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MessageRepositoryTest {

    @InjectMocks
    private MessageRepository messageRepository;

    @Test
    public void get_テスト() {
        assertThat(messageRepository.get())
                .isEqualTo("this is MessageRepository");
    }
}
