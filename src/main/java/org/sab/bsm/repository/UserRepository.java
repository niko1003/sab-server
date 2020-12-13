package org.sab.bsm.repository;

import org.sab.bsm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Boolean existsByEmail(String email);

	Boolean existsByUsername(String username);

	User findByUsername(String username);
}