package com.infosys.seatsync.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockId;

    private String blockName;
    private Integer totalSeats;

    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    @ManyToOne
    @JoinColumn(name = "dc_id")
    private DeliveryCenter deliveryCenter;

    public Block() {
    }

    public enum AccessType {
        RESTRICTED, UNRESTRICTED
    }

    @Override
    public String toString() {
        return "Block{" +
                "blockId=" + blockId +
                ", blockName='" + blockName + '\'' +
                ", totalSeats=" + totalSeats +
                ", accessType=" + accessType +
                ", deliveryCenter=" + deliveryCenter +
                '}';
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public DeliveryCenter getDeliveryCenter() {
        return deliveryCenter;
    }

    public void setDeliveryCenter(DeliveryCenter deliveryCenter) {
        this.deliveryCenter = deliveryCenter;
    }
}

