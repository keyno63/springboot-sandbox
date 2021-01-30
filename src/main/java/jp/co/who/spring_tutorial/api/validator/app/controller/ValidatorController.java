package jp.co.who.spring_tutorial.api.validator.app.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.BookCategory;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.BookData;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.CategorisedBookData;
import jp.co.who.spring_tutorial.api.jpa.bookmark.service.CategorisedBookService;
import jp.co.who.spring_tutorial.api.validator.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ValidatorController {

    private final UserService userService;

    ValidatorController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/validation")
    public ResponseEntity<ValidationResponse> get(@RequestParam String userId) {
        Boolean isDuplicate = userService.checkDuplicate(userId);
        return ResponseEntity.ok(new ValidationResponse(isDuplicate));
    }

    public static class ValidationResponse {
        @JsonProperty Boolean duplicated;

        ValidationResponse(Boolean duplicated) {
            this.duplicated = duplicated;
        }
    }
}
