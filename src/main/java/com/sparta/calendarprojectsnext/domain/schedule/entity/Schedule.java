package com.sparta.calendarprojectsnext.domain.schedule.entity;

import com.sparta.calendarprojectsnext.domain.audit.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schedule extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username", nullable = false, length = 20)
    private String userName;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "scheduledetails", nullable = false)
    private String scheduleDetails;
}
