package com.banks.lostunes.repo;

import com.banks.lostunes.model.AppUser;
import com.banks.lostunes.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by banks on 002 Aug 02 2017 7:06 AM.
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}
