package com.infosys.seatsync.entity.emp;

import com.infosys.seatsync.entity.emp.Employee;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AttendanceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    private String swipeTime;
    private String location;
    private String status;  // IN / OUT

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
}
