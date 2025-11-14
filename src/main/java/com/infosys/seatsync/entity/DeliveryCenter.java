package com.infosys.seatsync.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DeliveryCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dcId;

    private String dcName;
    private String location;

    @Override
    public String toString() {
        return "DeliveryCenter{" +
                "dcId=" + dcId +
                ", dcName='" + dcName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Long getDcId() {
        return dcId;
    }

    public void setDcId(Long dcId) {
        this.dcId = dcId;
    }

    public String getDcName() {
        return dcName;
    }

    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

