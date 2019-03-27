package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Designation;
import com.arefin.sunshinefarm.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees, Long> {
    Optional<Employees> findByName(String name);
    List<Employees> findAllByDesignation(Set<Designation> designation);
    boolean existsByName(String name);
}
