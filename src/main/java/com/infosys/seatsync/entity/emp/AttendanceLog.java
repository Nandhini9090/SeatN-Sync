package com.infosys.seatsync.entity.emp;

import com.infosys.seatsync.entity.emp.Employee;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class AttendanceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    private LocalDateTime swipeTime;
    private String location;
    private String status;  // IN / OUT

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public LocalDateTime getSwipeTime() {
        return swipeTime;
    }

    public void setSwipeTime(LocalDateTime swipeTime) {
        this.swipeTime = swipeTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
