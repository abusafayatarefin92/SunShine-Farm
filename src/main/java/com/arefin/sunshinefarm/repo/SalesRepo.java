package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Crops;
import com.arefin.sunshinefarm.entity.Equipment;
import com.arefin.sunshinefarm.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Long> {
    Optional<Sales> findByProductName(String name);
    List<Sales> findAllByCrops(Set<Crops> crops);
    boolean existsByProductName(String name);
    Sales findByProductCode(String productCode);
}
