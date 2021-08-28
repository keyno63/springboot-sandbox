package jp.co.who.spring_tutorial.api.jpa.bookmark.domain.service;

import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.BookCategory;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.BookData;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.CategorisedBookData;

import java.util.List;

public interface CategorisedBookService {
    List<CategorisedBookData> get();
    List<BookData> getBook();
    List<BookCategory> getBookCategory();
}
