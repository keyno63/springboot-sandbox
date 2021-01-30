package jp.co.who.spring_tutorial.api.validator.users.service;

import jp.co.who.spring_tutorial.api.validator.users.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
