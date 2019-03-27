package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Crops;
import com.arefin.sunshinefarm.entity.Designation;
import com.arefin.sunshinefarm.entity.Employees;
import com.arefin.sunshinefarm.entity.Pesticides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface PesticidesRepo extends JpaRepository<Pesticides, Long> {
    Optional<Pesticides> findByName(String name);
    List<Pesticides> findAllByCrops(Set<Crops> crops);
    boolean existsByName(String name);
}
