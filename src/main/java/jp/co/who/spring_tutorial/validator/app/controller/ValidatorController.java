package jp.co.who.spring_tutorial.validator.app.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.who.spring_tutorial.validator.bookmark.domain.BookCategory;
import jp.co.who.spring_tutorial.validator.bookmark.domain.BookData;
import jp.co.who.spring_tutorial.validator.bookmark.domain.CategorisedBookData;
import jp.co.who.spring_tutorial.validator.bookmark.service.CategorisedBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ValidatorController {

    private final CategorisedBookService categorisedBookService;

    ValidatorController(CategorisedBookService categorisedBookService) {
        this.categorisedBookService = categorisedBookService;
    }

    @GetMapping("/validation")
    public String get() {
        return "hoge";
    }

    @GetMapping("/validation/sql/categorise")
    public ResponseEntity<ValidationResponse> categorise() {
        List<CategorisedBookData> res = categorisedBookService.get();
        return ResponseEntity.ok()
                .body(new ValidationResponse(res));
    }

    @GetMapping("/validation/sql/book")
    public ResponseEntity<BookResponse> book() {
        List<BookData> res = categorisedBookService.getBook();
        return ResponseEntity.ok()
                .body(new BookResponse(res));
    }

    @GetMapping("/validation/sql/combine")
    public ResponseEntity<ValidationResponse> combine() {
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
                .body(new ValidationResponse(res));
    }

    public static class ValidationResponse {

        @JsonProperty private List<CategorisedBookData> categorisedBookDataList;

        ValidationResponse(List<CategorisedBookData> categorisedBookDataList) {
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
