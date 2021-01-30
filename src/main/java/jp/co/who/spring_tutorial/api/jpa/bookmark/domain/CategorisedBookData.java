package jp.co.who.spring_tutorial.api.jpa.bookmark.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class CategorisedBookData {

    @Id
    private Integer id;
    private String bookCategoryName;
    private String name;

    public CategorisedBookData(Integer id, String bookCategoryName, String name) {
        this.id = id;
        this.bookCategoryName = bookCategoryName;
        this.name = name;
    }

    public CategorisedBookData() {}
}
