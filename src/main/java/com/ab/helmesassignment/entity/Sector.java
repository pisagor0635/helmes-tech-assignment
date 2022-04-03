package com.ab.helmesassignment.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
