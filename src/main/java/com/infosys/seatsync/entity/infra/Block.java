package com.infosys.seatsync.entity.infra;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockId;

    private String blockName;
    @ManyToOne
    @JoinColumn(name = "dc_id")
    private DeliveryCenter deliveryCenter;

    @OneToMany(mappedBy = "block")
    private List<Wing> wings;

    public Block() {
    }

    @Override
    public String toString() {
        return "Block{" +
                "blockId=" + blockId +
                ", blockName='" + blockName + '\'' +
                ", deliveryCenter=" + deliveryCenter +
                ", wings=" + wings +
                '}';
    }

    public List<Wing> getWings() {
        return wings;
    }

    public void setWings(List<Wing> wings) {
        this.wings = wings;
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

    public DeliveryCenter getDeliveryCenter() {
        return deliveryCenter;
    }

    public void setDeliveryCenter(DeliveryCenter deliveryCenter) {
        this.deliveryCenter = deliveryCenter;
    }
}

