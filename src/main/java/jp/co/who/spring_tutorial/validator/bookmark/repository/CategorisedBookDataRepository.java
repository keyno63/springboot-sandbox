package jp.co.who.spring_tutorial.validator.bookmark.repository;

import jp.co.who.spring_tutorial.validator.bookmark.domain.CategorisedBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorisedBookDataRepository extends JpaRepository<CategorisedBookData, Integer> {

    @Query(value = "select b.id as id, c.name as book_category_name, b.name as name "
            + "from book b "
            + "left join book_category c on c.id = b.book_category_id "
            + "order by b.id ",
            nativeQuery = true)
    List<CategorisedBookData> findAll();
}
