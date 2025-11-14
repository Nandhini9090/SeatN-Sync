package com.infosys.seatsync.controller;

import com.infosys.seatsync.dto.DCInfoResponseDto;
import com.infosys.seatsync.service.DCDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/infy/dc")
public class DCDetailsController {

    private final DCDetailsService dcDetailsService;

    public DCDetailsController(DCDetailsService dcDetailsService) {
        this.dcDetailsService = dcDetailsService;
    }

    @GetMapping("/details")
    public ResponseEntity<DCInfoResponseDto> getAllDCInfo(){
        return new ResponseEntity<>(dcDetailsService.getAllDCInfo(), HttpStatus.OK);
    }



}
