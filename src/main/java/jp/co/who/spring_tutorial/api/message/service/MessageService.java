package jp.co.who.spring_tutorial.api.message.service;

import jp.co.who.spring_tutorial.api.message.repository.MessageRepository;
import org.springframework.context.MessageSource;import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private MessageSource messageSource;

    final private MessageRepository messageRepository;

    public MessageService(MessageSource messageSource, MessageRepository mr) {
        this.messageSource = messageSource;
        this.messageRepository = mr;
    }

    public String get() {
        return messageRepository.get();
    }

    public String getMessageByCode(String code) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }
}
