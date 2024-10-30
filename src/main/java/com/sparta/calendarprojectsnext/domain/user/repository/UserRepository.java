package com.sparta.calendarprojectsnext.domain.user.repository;

import com.sparta.calendarprojectsnext.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  boolean existsByEmail(String email);

  boolean existsByUserName(String username);

  Optional<User> findByEmail(String email);

  Optional<User> findById(Long id);

  Optional<User> findByEmailOrUserName(String email, String userName);
}
