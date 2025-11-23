package com.infosys.seatsync.service.impl;

import com.infosys.seatsync.dto.AttendanceResponseDto;
import com.infosys.seatsync.entity.emp.AttendanceLog;
import com.infosys.seatsync.entity.emp.Employee;
import com.infosys.seatsync.exception.BusinessException;
import com.infosys.seatsync.repository.AttendanceLogRepository;
import com.infosys.seatsync.repository.EmployeeRepository;
import com.infosys.seatsync.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceLogRepository attendanceLogRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public AttendanceResponseDto markAttendanceForEmp(String emp, String location, String status) {

        try {

            LocalDate today = LocalDate.now();
            LocalDateTime startOfDay = today.atStartOfDay();
            LocalDateTime endOfDay = today.atTime(23, 59, 59);


            //level 1 - Check if the emp has attendance record for the same date
            boolean isAttendanceExists = attendanceLogRepository.existsByEmployee_EmpIdAndSwipeTimeBetween(emp, startOfDay, endOfDay);
            if(!isAttendanceExists){
                AttendanceResponseDto attendanceResponseDto = new AttendanceResponseDto();

                AttendanceLog attendanceLog = new AttendanceLog();
                Optional<Employee> employeeOpt = employeeRepository.findById(emp);
                if(employeeOpt.isEmpty()){
                    attendanceResponseDto.setStatus("INVALID_EMP");
                    attendanceResponseDto.setMessage("Unable to fetch the emp object");
                    return attendanceResponseDto;
                }
                attendanceLog.setEmployee(employeeOpt.get());
                attendanceLog.setLocation(location);
                attendanceLog.setSwipeTime(LocalDateTime.now());
                attendanceLog.setStatus(status);
                attendanceLogRepository.save(attendanceLog);

                attendanceResponseDto.setTimestamp(Instant.now());
                attendanceResponseDto.setStatus("SUCCESS");
                attendanceResponseDto.setMessage("Employee Attendance has been recorded");
                return attendanceResponseDto;
            } else {
                throw new BusinessException("ATTENDANCE_EXISTS", "Attendance record already is already present ");
            }

        } catch (Exception exception){
            throw new BusinessException("ERROR", exception.getMessage());
        }
    }
}
