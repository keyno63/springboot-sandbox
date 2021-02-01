package jp.co.who.spring_tutorial.api.jpa.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String password;

    private String firstName;

    private String lastName;
}
