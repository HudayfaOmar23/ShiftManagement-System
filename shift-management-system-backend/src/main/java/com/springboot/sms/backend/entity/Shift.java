package com.springboot.sms.backend.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "shifts")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shift_name", nullable = false)
    private String shiftName;

    @Column(name = "shift_start")
    private LocalTime shiftStart;

    @Column(name = "shift_end")
    private LocalTime shiftEnd;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


   

    public Shift() {}

    public Shift(Long id, String shiftName, LocalTime shiftStart, LocalTime shiftEnd) {
        this.id = id;
        this.shiftName = shiftName;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public LocalTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public LocalTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(LocalTime shiftEnd) {
        this.shiftEnd = shiftEnd;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

 
}
