package com.infosys.seatsync.repository;

import com.infosys.seatsync.entity.booking.QRCheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRCheckInRepository extends JpaRepository<QRCheckIn, Long> {
}
