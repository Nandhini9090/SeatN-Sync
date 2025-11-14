package com.infosys.seatsync.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private String cityName;
    private List<DataCenterDto> dataCenters;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<DataCenterDto> getDataCenters() {
        return dataCenters;
    }

    public void setDataCenters(List<DataCenterDto> dataCenters) {
        this.dataCenters = dataCenters;
    }
}

