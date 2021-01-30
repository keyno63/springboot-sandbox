package jp.co.who.spring_tutorial.validator.app.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.who.spring_tutorial.validator.bookmark.domain.BookCategory;
import jp.co.who.spring_tutorial.validator.bookmark.domain.BookData;
import jp.co.who.spring_tutorial.validator.bookmark.domain.CategorisedBookData;
import jp.co.who.spring_tutorial.validator.bookmark.service.CategorisedBookService;
import jp.co.who.spring_tutorial.validator.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ValidatorController {

    private final UserService userService;
    private final CategorisedBookService categorisedBookService;

    ValidatorController(UserService userService, CategorisedBookService categorisedBookService) {
        this.userService = userService;
        this.categorisedBookService = categorisedBookService;
    }

    @GetMapping("/validation")
    public ResponseEntity<ValidationResponse> get(@RequestParam String userId) {
        Boolean isDuplicate = userService.checkDuplicate(userId);
        return ResponseEntity.ok(new ValidationResponse(isDuplicate));
    }

    @GetMapping("/validation/sql/categorise")
    public ResponseEntity<CategorizedBookmarkResponse> categorise() {
        List<CategorisedBookData> res = categorisedBookService.get();
        return ResponseEntity.ok()
                .body(new CategorizedBookmarkResponse(res));
    }

    @GetMapping("/validation/sql/book")
    public ResponseEntity<BookResponse> book() {
        List<BookData> res = categorisedBookService.getBook();
        return ResponseEntity.ok()
                .body(new BookResponse(res));
    }

    @GetMapping("/validation/sql/combine")
    public ResponseEntity<CategorizedBookmarkResponse> combine() {
        List<BookData> resBook = categorisedBookService.getBook();
        List<BookCategory> resCategory = categorisedBookService.getBookCategory();
        List<CategorisedBookData> res = resBook
                .stream()
                .map(book -> {
                    for (BookCategory bc: resCategory) {
                        if (bc.getId().equals(book.getCategoryId())) {
                            return new CategorisedBookData(book.getId(), bc.getName(), book.getName());
                        }
                    }
                    return new CategorisedBookData();
                })
                .filter(converted -> converted.getId() != null) // ないと思うが、マッチしなかったものは削除
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(new CategorizedBookmarkResponse(res));
    }

    public static class ValidationResponse {
        @JsonProperty Boolean duplicated;

        ValidationResponse(Boolean duplicated) {
            this.duplicated = duplicated;
        }
    }

    public static class CategorizedBookmarkResponse {
        @JsonProperty private List<CategorisedBookData> categorisedBookDataList;

        CategorizedBookmarkResponse(List<CategorisedBookData> categorisedBookDataList) {
            this.categorisedBookDataList = categorisedBookDataList;
        }
    }

    public static class BookResponse {
        @JsonProperty private List<BookData> bookDataList;

        BookResponse(List<BookData> bookDataList) {
            this.bookDataList = bookDataList;
        }
    }
}
