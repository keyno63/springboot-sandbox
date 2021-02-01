package jp.co.who.spring_tutorial.api.jpa.bookmark.controller;

import jp.co.who.spring_tutorial.api.jpa.bookmark.controller.response.BookResponse;
import jp.co.who.spring_tutorial.api.jpa.bookmark.controller.response.CategorizedBookmarkResponse;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.BookCategory;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.BookData;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.CategorisedBookData;
import jp.co.who.spring_tutorial.api.jpa.bookmark.service.CategorisedBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jpa/bookmark")
public class BookmarkController {

    private final CategorisedBookService categorisedBookService;

    BookmarkController(CategorisedBookService categorisedBookService) {
        this.categorisedBookService = categorisedBookService;
    }

    @GetMapping("/categorise")
    public ResponseEntity<CategorizedBookmarkResponse> categorise() {
        List<CategorisedBookData> res = categorisedBookService.get();
        return ResponseEntity.ok()
                .body(new CategorizedBookmarkResponse(res));
    }

    @GetMapping("/book")
    public ResponseEntity<BookResponse> book() {
        List<BookData> res = categorisedBookService.getBook();
        return ResponseEntity.ok()
                .body(new BookResponse(res));
    }

    @GetMapping("/combine")
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
}
