package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Role;
import netscape.security.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);
    boolean existsRoleByRoleName(String roleName);
}
