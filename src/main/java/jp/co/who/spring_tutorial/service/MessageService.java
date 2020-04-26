package jp.co.who.spring_tutorial.service;

import jp.co.who.spring_tutorial.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
