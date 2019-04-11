package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesignationRepo extends JpaRepository<Designation, Long> {
    Optional<Designation> findByDesignationName(String designationName);
    boolean existsDesignationByDesignationName(String designationName);
}
