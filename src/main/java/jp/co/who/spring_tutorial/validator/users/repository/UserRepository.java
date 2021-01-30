package jp.co.who.spring_tutorial.validator.users.repository;

import jp.co.who.spring_tutorial.validator.users.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserData, String> {

    List<UserData> findAll();

    UserData findOneForUpdateById(String userId);

    long countById(String userId);
}
