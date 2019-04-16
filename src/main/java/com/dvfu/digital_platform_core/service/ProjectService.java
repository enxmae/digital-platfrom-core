package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll(Long id);

    Project findById(Long id);

    Project insert(Project project);

    void delete(Long projectId);

    Project update(Long id, Project project);


}
