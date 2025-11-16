package com.infosys.seatsync.repository;

import com.infosys.seatsync.entity.emp.AttendanceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AttendanceLogRepository extends JpaRepository<AttendanceLog, Long> {

    boolean existsByEmployee_EmpIdAndSwipeTimeBetween(
            String empId,
            LocalDateTime startOfDay,
            LocalDateTime endOfDay
    );
}
