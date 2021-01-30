package jp.co.who.spring_tutorial.api.validator.users;

import lombok.Getter;

@Getter
public class User {
    private final String userId;

    private final String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
