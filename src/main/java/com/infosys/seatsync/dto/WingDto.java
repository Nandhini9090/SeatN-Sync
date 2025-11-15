package com.infosys.seatsync.dto;

import com.infosys.seatsync.entity.infra.Wing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WingDto {
    private Long wingId;
    private String wingName;
    private Wing.AccessType accessType;

    public Long getWingId() {
        return wingId;
    }

    public Wing.AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(Wing.AccessType accessType) {
        this.accessType = accessType;
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
}
