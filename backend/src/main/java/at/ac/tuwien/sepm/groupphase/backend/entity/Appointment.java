package at.ac.tuwien.sepm.groupphase.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="application_appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private ApplicationUser user;

    public Appointment(Long id, String description, LocalDateTime startTime, LocalDateTime endTime, ApplicationUser user) {
    this.id = id;
    this.description = description;
    this.startTime = startTime;
    this.endTime = endTime;
    this.user = user;
    }
public Appointment() {
    }

public Long getId() {
    return id;
    }
public String getDescription() {
    return description;
    }
public LocalDateTime getStartTime() {
    return startTime;
    }
public LocalDateTime getEndTime() {
    return endTime;
    }
public ApplicationUser getUser() {
    return user;
    }

public void setId(Long id) {
    this.id = id;
    }
public void setDescription(String description) {
    this.description = description;
    }
public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
    }
public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
    }
public void setUser(ApplicationUser user) {
    this.user = user;
    }

}
