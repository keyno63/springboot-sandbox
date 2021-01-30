package jp.co.who.spring_tutorial.validator.bookmark.service;

import jp.co.who.spring_tutorial.validator.bookmark.domain.BookCategory;
import jp.co.who.spring_tutorial.validator.bookmark.domain.BookData;
import jp.co.who.spring_tutorial.validator.bookmark.domain.CategorisedBookData;
import jp.co.who.spring_tutorial.validator.bookmark.repository.BookCategoryRepository;
import jp.co.who.spring_tutorial.validator.bookmark.repository.BookRepository;
import jp.co.who.spring_tutorial.validator.bookmark.repository.CategorisedBookDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorisedBookService {

    private final CategorisedBookDataRepository repository;

    private final BookRepository bookRepository;

    private final BookCategoryRepository bookCategoryRepository;

    CategorisedBookService(CategorisedBookDataRepository repository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public List<CategorisedBookData> get() {
        return repository.find();
    }

    public List<BookData> getBook() {
        return bookRepository.find();
    }

    public List<BookCategory> getBookCategory() {
        return bookCategoryRepository.find();
    }
}
