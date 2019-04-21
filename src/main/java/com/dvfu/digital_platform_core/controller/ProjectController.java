package com.dvfu.digital_platform_core.controller;


import com.dvfu.digital_platform_core.dao.Project;
import com.dvfu.digital_platform_core.service.ProjectService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/projects")

public class ProjectController {

    private final ProjectService projectService;

    ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/spna/{spna_id}")
    @PreAuthorize("hasRole('SPNA')")
    public List<Project> getSPNAsProjects(@PathVariable Long spna_id) {
        return projectService.findAll(spna_id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SPNA', 'TOUR_OPERATOR')")
    public Project getProductById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @GetMapping
    public List<Project> getAll() {
        return projectService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('SPNA')")
    public Project insert(@RequestBody Project project) {
        return projectService.insert(project);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SPNA')")
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('SPNA')")
    public Project update(@RequestBody Project project) {
        return projectService.update(project.getId(), project);
    }

    @GetMapping("/spna/{spna_id}/{tour_id}")
    @PreAuthorize("hasRole('SPNA')")
    public Project finishProgress(@PathVariable Long spnaId, @RequestBody Project project) {
        if(projectService.checkOwner(spnaId, project))
            projectService.setFinishedStatus(project);

        return project;
    }

}

