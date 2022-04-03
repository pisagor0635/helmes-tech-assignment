package com.ab.helmesassignment.controller;

import com.ab.helmesassignment.dto.SectorDTO;
import com.ab.helmesassignment.dto.UserDTO;
import com.ab.helmesassignment.service.SectorService;
import com.ab.helmesassignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentController {

    private final SectorService sectorService;
    private final UserService userService;

    @GetMapping("/getSectorList")
    public List<SectorDTO> getSectorList() {
        return sectorService.getSectors();
    }

    @PostMapping(value = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveEmployee(@RequestBody UserDTO user) {
        return userService.saveUser(user);
    }
}
