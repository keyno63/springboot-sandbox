package jp.co.who.spring_tutorial.api.jpa.bookmark.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class BookCategory {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
}
