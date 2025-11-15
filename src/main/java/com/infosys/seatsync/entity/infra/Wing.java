package com.infosys.seatsync.entity.infra;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @ToString.Exclude
    private Block block;

    public enum AccessType {
        RESTRICTED, UNRESTRICTED
    }

    @Override
    public String toString() {
        return "Wing{" +
                "wingId=" + wingId +
                ", wingName='" + wingName + '\'' +
                ", totalSeats=" + totalSeats +
                ", accessType=" + accessType +
                '}';
    }

    public Long getWingId() {
        return wingId;
    }

    public void setWingId(Long wingId) {
        this.wingId = wingId;
    }

    public String getWingName() {
        return wingName;
    }

    public void setWingName(String wingName) {
        this.wingName = wingName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
