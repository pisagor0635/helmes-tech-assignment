package com.ab.helmesassignment.repository;

import com.ab.helmesassignment.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    List<Sector> findAllByOrderByIdAscParentIdAsc();
}
