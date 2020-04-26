package jp.co.who.spring_tutorial.controller;

import jp.co.who.spring_tutorial.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/message")
public class MessageController {

    final private MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/get")
    public String get() {
        return messageService.get();
    }
}
