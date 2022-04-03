package com.ab.helmesassignment.dto;

import lombok.Data;

@Data
public class UserDTO {

    private long id;
    private String fullName;
    private boolean termAgreed;
    long[] sector;

}
