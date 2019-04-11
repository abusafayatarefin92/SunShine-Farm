package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Crops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropsRepo extends JpaRepository<Crops, Long> {
    Crops findByName(String name);
    Crops findByProductCode(String productCode);
}
