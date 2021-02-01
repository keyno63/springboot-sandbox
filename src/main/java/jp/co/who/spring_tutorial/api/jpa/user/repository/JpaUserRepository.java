package jp.co.who.spring_tutorial.api.jpa.user.repository;

import jp.co.who.spring_tutorial.api.jpa.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaUserRepository extends JpaRepository<User, String> {

    @Query("SELECT X FROM User X ORDER BY X.firstName, X.lastName")
    Page<User> findAllOrderByName(Pageable pageable);
}
