package com.dvfu.digital_platform_core.repository;

import com.dvfu.digital_platform_core.dao.Authority;
import com.dvfu.digital_platform_core.dao.UserRoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByAuthority(UserRoleName authority);
}
