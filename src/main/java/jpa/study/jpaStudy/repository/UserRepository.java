package jpa.study.jpaStudy.repository;

import jpa.study.jpaStudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
