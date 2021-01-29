package jp.co.who.spring_tutorial.validator.users;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static List<User> users = List.of(
            new User("user1", "abcd"),
            new User("user2", "1234")
    );

    public boolean checkDuplicate(String userId) {
        if (countByUserId(userId) > 0) {
            return false;
        }
        return true;
    }

    private int countByUserId(String userId) {
        return (int) users
                .stream()
                .filter(user -> user.getUserId().equals(userId))
                .count();
    }
}
