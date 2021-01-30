package jp.co.who.spring_tutorial.validator.bookmark.repository;

import jp.co.who.spring_tutorial.validator.bookmark.domain.BookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookData, Integer> {

    @Query(value = "select b.id as id, b.book_category_id as category_id, b.name as name "
            + "from book b ",
            nativeQuery = true)
    List<BookData> findAll();
}
