package com.saltlux.laptopstorage.repository;

import com.saltlux.laptopstorage.model.role.ERole;
import com.saltlux.laptopstorage.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
}
