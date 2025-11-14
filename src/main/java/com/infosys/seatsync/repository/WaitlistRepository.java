package com.infosys.seatsync.repository;

import com.infosys.seatsync.entity.booking.Waitlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitlistRepository extends JpaRepository<Waitlist, Long> {

}
