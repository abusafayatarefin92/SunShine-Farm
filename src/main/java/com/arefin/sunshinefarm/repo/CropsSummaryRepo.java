package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.CropsSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropsSummaryRepo extends JpaRepository<CropsSummary, Long> {
    CropsSummary findByProductCode(String productCode);
}
