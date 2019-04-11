package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Role;
import com.arefin.sunshinefarm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public Optional<User> findByUserNameOrEmail(String userName, String email);
/*
    Optional<User> findByUserName(String userName);
*/
User findByUserName(String userName);
    Optional<User> findByEmail(String email);
    List<User> findAllByRoles(Set<Role> roles);
    List<User> findAllByUserName(String userName);
    User findByName(String name);
    boolean existsByEmail(String email);
    User findByConfirmationToken(String token);



}
