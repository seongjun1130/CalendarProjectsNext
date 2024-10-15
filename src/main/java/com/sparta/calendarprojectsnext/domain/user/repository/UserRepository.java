package com.sparta.calendarprojectsnext.domain.user.repository;

import com.sparta.calendarprojectsnext.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByUserName(String username);
}
