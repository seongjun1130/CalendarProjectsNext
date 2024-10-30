package com.sparta.calendarprojectsnext.domain.comment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.calendarprojectsnext.domain.audit.Auditable;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends Auditable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "comment", nullable = false, length = 100)
  private String comment;

  @Column(name = "username", nullable = false, length = 20)
  private String userName;

  @ManyToOne
  @JoinColumn(name = "schedule_id")
  @JsonIgnore
  private Schedule schedule;
}
