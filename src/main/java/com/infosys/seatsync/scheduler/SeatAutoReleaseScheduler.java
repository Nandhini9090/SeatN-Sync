package com.infosys.seatsync.scheduler;

import com.infosys.seatsync.entity.booking.Booking;
import com.infosys.seatsync.entity.booking.QRCheckIn;
import com.infosys.seatsync.repository.QRCheckInRepository;
import com.infosys.seatsync.repository.SeatBookingRepository;
import com.infosys.seatsync.service.impl.QRCheckInServiceImpl;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class SeatAutoReleaseScheduler {

    @Autowired
    SeatBookingRepository seatBookingRepository;

    @Autowired
    QRCheckInRepository qrCheckInRepository;

    private static final Logger logger = LoggerFactory.getLogger(SeatAutoReleaseScheduler.class);

    @Transactional
    @Scheduled(fixedRate = 300000) // runs every 5 minutes
    public void autoReleaseExpiredBookings() {
        logger.info("Running auto release...");
        LocalDate today = LocalDate.now();
        String todayStr = today.toString();

        List<Booking> bookings = seatBookingRepository.findTodayBooked(todayStr);

        LocalDateTime now = LocalDateTime.now();

        for (Booking booking : bookings) {

            // 1. Convert date + startTime to LocalDateTime
            LocalDate date = LocalDate.parse(booking.getBookingDate());
            LocalTime start = LocalTime.parse(booking.getStartTime());
            LocalDateTime startDateTime = LocalDateTime.of(date, start);

            // 2. Add buffer of 45 mins
            LocalDateTime bufferEnd = startDateTime.plusMinutes(45);

            // 3. Check if current time > buffer time
            if (now.isAfter(bufferEnd)) {

                // 4. Check if check-in exists
                QRCheckIn checkIn = qrCheckInRepository.findByBookingId(booking.getBookingId());

                if (checkIn == null) {
                    booking.setStatus(Booking.BookingStatus.AUTO_RELEASED);
                    seatBookingRepository.save(booking);

                    logger.info("Auto-released booking: " + booking.getBookingId() + " for employee :"+ booking.getEmployee().getEmpId());
                }
            }
        }
    }
}

