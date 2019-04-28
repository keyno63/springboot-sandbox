package jp.co.who.spring_tutorial.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {
    @Autowired
    private MessageSource messageSource;

    public String getMessageByCode(String code) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }
}
