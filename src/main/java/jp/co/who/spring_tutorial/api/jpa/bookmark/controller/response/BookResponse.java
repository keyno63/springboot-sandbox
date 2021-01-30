package jp.co.who.spring_tutorial.api.jpa.bookmark.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.BookData;

import java.util.List;

public class BookResponse {
    @JsonProperty
    private List<BookData> bookDataList;

    public BookResponse(List<BookData> bookDataList) {
        this.bookDataList = bookDataList;
    }
}
