package jp.co.who.spring_tutorial.api.jpa.bookmark.service;

import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.BookCategory;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.BookData;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.CategorisedBookData;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.service.CategorisedBookService;
import jp.co.who.spring_tutorial.api.jpa.bookmark.repository.BookCategoryRepository;
import jp.co.who.spring_tutorial.api.jpa.bookmark.repository.BookRepository;
import jp.co.who.spring_tutorial.api.jpa.bookmark.repository.CategorisedBookDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorisedBookServiceImpl implements CategorisedBookService {

    private final CategorisedBookDataRepository repository;

    private final BookRepository bookRepository;

    private final BookCategoryRepository bookCategoryRepository;

    CategorisedBookServiceImpl(CategorisedBookDataRepository repository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public List<CategorisedBookData> get() {
        return repository.findAll();
    }

    public List<BookData> getBook() {
        return bookRepository.findAll();
    }

    public List<BookCategory> getBookCategory() {
        return bookCategoryRepository.findAll();
    }
}
