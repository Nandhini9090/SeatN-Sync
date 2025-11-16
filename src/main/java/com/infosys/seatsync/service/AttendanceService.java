package com.infosys.seatsync.service;

import com.infosys.seatsync.dto.AttendanceResponseDto;

public interface AttendanceService {

    AttendanceResponseDto markAttendanceForEmp(String emp, String location, String status);
}
