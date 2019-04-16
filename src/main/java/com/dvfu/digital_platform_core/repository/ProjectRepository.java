package com.dvfu.digital_platform_core.repository;

import com.dvfu.digital_platform_core.dao.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByOwner_Id(Long id);

}
