package jp.co.who.spring_tutorial.api.message.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

    public String get() {
        return "this is MessageRepository";
    }
}
