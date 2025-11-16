package com.infosys.seatsync.controller;

import com.infosys.seatsync.dto.AttendanceResponseDto;
import com.infosys.seatsync.dto.qr.QRCheckInResponseDto;
import com.infosys.seatsync.service.AttendanceService;
import com.infosys.seatsync.service.QRCheckInService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/infy")
public class QRCheckInController {

    private QRCheckInService qrCheckInService;

    private AttendanceService attendanceService;

    public QRCheckInController(QRCheckInService qrCheckInService, AttendanceService attendanceService) {
        this.qrCheckInService = qrCheckInService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/checkIn")
    public ResponseEntity<QRCheckInResponseDto> processQRCheckIn(@RequestParam String seatHashCode,
                                                                 @RequestParam String empId){
        return new ResponseEntity<>(qrCheckInService.processCheckIn(seatHashCode, empId), HttpStatus.OK);
    }

    @PostMapping("/attendance")
    public ResponseEntity<AttendanceResponseDto> markAttendanceForEmp(@RequestParam String empId,
                                                                  @RequestParam String location, @RequestParam String status){
        return new ResponseEntity<>(attendanceService.markAttendanceForEmp(empId, location, status), HttpStatus.OK);
    }

}
