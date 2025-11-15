package com.infosys.seatsync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockDto {
    private Long blockId;
    private String blockName;
    private List<WingDto> wings;

    public Long getBlockId() {
        return blockId;
    }

    public List<WingDto> getWings() {
        return wings;
    }

    public void setWings(List<WingDto> wings) {
        this.wings = wings;
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
}

