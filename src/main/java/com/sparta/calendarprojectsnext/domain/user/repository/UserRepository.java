package com.sparta.calendarprojectsnext.domain.user.repository;

import com.sparta.calendarprojectsnext.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByUserName(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);
}
