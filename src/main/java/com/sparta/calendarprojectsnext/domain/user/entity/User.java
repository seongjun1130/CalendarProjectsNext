package com.sparta.calendarprojectsnext.domain.user.entity;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.NOT_ADMIN;

import com.sparta.calendarprojectsnext.domain.audit.Auditable;
import com.sparta.calendarprojectsnext.domain.config.PasswordEncoder;
import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.user.eunm.UserRole;
import com.sparta.calendarprojectsnext.domain.userschedule.entity.UserSchedule;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends Auditable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username", nullable = false, length = 20, unique = true)
  private String userName;

  @Column(name = "email", nullable = false, length = 50, unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String passWord;

  @Column(name = "role", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private UserRole role;

  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<UserSchedule> userSchedules = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
  private List<Schedule> schedules = new ArrayList<>();

  public boolean isValidPassword(String password, PasswordEncoder pwEncoder) {
    return pwEncoder.matches(password, passWord);
  }

  public void isAdmin() {
    if (!role.equals(UserRole.ADMIN)) {
      throw new CustomException(NOT_ADMIN);
    }
  }
}
