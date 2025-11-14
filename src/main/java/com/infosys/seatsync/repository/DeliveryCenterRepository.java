package com.infosys.seatsync.repository;

import com.infosys.seatsync.entity.infra.DeliveryCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryCenterRepository extends JpaRepository<DeliveryCenter, Long> {
}
