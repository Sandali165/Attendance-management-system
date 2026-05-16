package com.example.attendance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * REST controller for attendance operations.
 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        logger.info("Status check at {}", timestamp);
        return ResponseEntity.ok("Attendance Service is Running | " + timestamp);
    }

    @PostMapping("/checkin")
    public ResponseEntity<String> checkInUser() {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        logger.info("Check-in recorded at {}", timestamp);
        return ResponseEntity.ok("Check-In Successful | " + timestamp);
    }
}
