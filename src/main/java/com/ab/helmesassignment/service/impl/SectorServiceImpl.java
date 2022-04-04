package com.ab.helmesassignment.service.impl;

import com.ab.helmesassignment.dto.SectorDTO;
import com.ab.helmesassignment.entity.Sector;
import com.ab.helmesassignment.repository.SectorRepository;
import com.ab.helmesassignment.service.SectorService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl implements SectorService {

    private final SectorRepository sectorRepository;

    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    @Override
    public List<SectorDTO> getSectors() {

        List<SectorDTO> sectorDTOList = new ArrayList<>();

        List<Sector> sectorList = sectorRepository.findAllByOrderByIdAscParentIdAsc();


        for (Sector sector : sectorList) {
            SectorDTO sectorDTO = mapper.map(sector, SectorDTO.class);
            sectorDTO.setHasChild(sectorList.stream().anyMatch(s2 -> s2.getParentId() == sector.getId()));
            sectorDTOList.add(sectorDTO);
        }
        return sectorDTOList;
    }
}
