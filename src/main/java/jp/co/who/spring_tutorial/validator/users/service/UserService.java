package jp.co.who.spring_tutorial.validator.users.service;

import jp.co.who.spring_tutorial.validator.users.User;
import jp.co.who.spring_tutorial.validator.users.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkDuplicate(String userId) {
        return userRepository.countById(userId) == 0;
    }
}
