package com.ab.helmesassignment.dto;

import lombok.Data;

@Data
public class SectorDTO {

    private long id;
    private String sectorName;
    private long parentId;
    private boolean hasChild;
}
