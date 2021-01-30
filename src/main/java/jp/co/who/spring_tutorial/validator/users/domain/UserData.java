package jp.co.who.spring_tutorial.validator.users.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@UserIdDuplicateCheck(message = "ID重複")
public class UserData {
    @Id
    @GeneratedValue
    private String id;

    private String password;

    private String fistName;

    private String lastName;
}
