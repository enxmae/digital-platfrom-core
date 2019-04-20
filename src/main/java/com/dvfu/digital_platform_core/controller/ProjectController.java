package com.dvfu.digital_platform_core.controller;


import com.dvfu.digital_platform_core.dao.Project;
import com.dvfu.digital_platform_core.service.ProjectService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/projects")
@PreAuthorize("hasRole('SPNA')")
public class ProjectController {

    private final ProjectService projectService;

    ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/spna/{spna_id}")
    public List<Project> getAll(@PathVariable Long spna_id) {
        return projectService.findAll(spna_id);
    }

    @GetMapping("/{id}")
    public Project getProductById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @PostMapping
    public Project insert(@RequestBody Project project) {
        return projectService.insert(project);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
    }

    @PutMapping
    public Project update(@RequestBody Project project) {
        return projectService.update(project.getId(), project);
    }

}

