package com.ab.helmesassignment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sectors")
@Data
public class Sector {

    @Id
    private long id;

    @Column(name = "sector_name")
    private String sectorName;

    @Column(name = "parent_id")
    private long parentId;

}
