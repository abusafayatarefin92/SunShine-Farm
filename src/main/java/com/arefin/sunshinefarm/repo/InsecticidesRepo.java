package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Crops;
import com.arefin.sunshinefarm.entity.Equipment;
import com.arefin.sunshinefarm.entity.Insecticides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface InsecticidesRepo extends JpaRepository<Insecticides, Long> {
    Optional<Insecticides> findByName(String name);
    List<Insecticides> findAllByCrops(Set<Crops> crops);
    boolean existsByName(String name);
}
