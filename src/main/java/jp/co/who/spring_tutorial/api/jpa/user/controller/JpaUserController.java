package jp.co.who.spring_tutorial.api.jpa.user.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.who.spring_tutorial.api.jpa.user.entity.User;
import jp.co.who.spring_tutorial.api.jpa.user.repository.JpaUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jpa/user")
public class JpaUserController {

    private final JpaUserRepository userRepository;

    JpaUserController(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/page")
    public ResponseEntity<JpaResponse> page() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<User> res = userRepository.findAllOrderByName(pageable);

        //Page<User> res = userRepository.findOrdered(pageable);
        return ResponseEntity.ok(new JpaResponse(res));
    }

    public static class JpaResponse {
        @JsonProperty Page<User> users;

        public JpaResponse(Page<User> users) {
            this.users = users;
        }
    }
}
