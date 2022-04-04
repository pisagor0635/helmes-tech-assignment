package com.ab.helmesassignment.controller;

import com.ab.helmesassignment.dto.SectorDTO;
import com.ab.helmesassignment.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SectorController {

    private final SectorService sectorService;

    @GetMapping("/getSectorList")
    public List<SectorDTO> getSectorList() {
        return sectorService.getSectors();
    }
}