package com.infosys.seatsync.repository;

import com.infosys.seatsync.entity.booking.QRCheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QRCheckInRepository extends JpaRepository<QRCheckIn, Long> {

    @Query("SELECT q FROM QRCheckIn q WHERE q.booking.bookingId = :bookingId")
    QRCheckIn findByBookingId(Long bookingId);

}
