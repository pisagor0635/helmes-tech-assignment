package com.ab.helmesassignment.service.impl;

import com.ab.helmesassignment.dto.SectorDTO;
import com.ab.helmesassignment.entity.Sector;
import com.ab.helmesassignment.repository.SectorRepository;
import com.ab.helmesassignment.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl implements SectorService {

    private final SectorRepository sectorRepository;

    @Override
    public List<SectorDTO> getSectors() {

        List<SectorDTO> sectorDTOList = new ArrayList<>();

        List<Sector> sectorList = sectorRepository.findAll();

        sectorList.forEach(s -> {
            SectorDTO sectorDTO = new SectorDTO();
            sectorDTO.setId(s.getId());
            sectorDTO.setSectorName(s.getSectorName());
            sectorDTO.setParentId(s.getParentId());
            sectorDTO.setHasChild(sectorList.stream().anyMatch(s2 -> s2.getParentId() == s.getId()));
            sectorDTOList.add(sectorDTO);
        });

        return sectorDTOList;
    }
}
