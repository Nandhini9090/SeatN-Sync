package com.infosys.seatsync.entity.infra;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    private String seatCode;
    private String cubicleId;
    private Boolean isAvailable = true;
    private String bookedBy;

    @ManyToOne
    @JoinColumn(name = "wing_id")
    private Wing wing;
}
