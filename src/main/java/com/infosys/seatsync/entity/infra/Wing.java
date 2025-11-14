package com.infosys.seatsync.entity.infra;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wingId;

    private String wingName;  // Wing A - First Floor

    private int totalSeats;

    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;

    public enum AccessType {
        RESTRICTED, UNRESTRICTED
    }

}
