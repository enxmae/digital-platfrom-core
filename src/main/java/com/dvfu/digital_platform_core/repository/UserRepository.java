package com.dvfu.digital_platform_core.repository;

import com.dvfu.digital_platform_core.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
