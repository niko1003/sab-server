package org.sab.bsm.repository;

import org.sab.bsm.model.Role;
import org.sab.bsm.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(RoleEnum name);
}
