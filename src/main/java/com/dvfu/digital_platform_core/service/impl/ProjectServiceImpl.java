package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.Project;
import com.dvfu.digital_platform_core.dao.ProjectProgress;
import com.dvfu.digital_platform_core.repository.ProjectRepository;
import com.dvfu.digital_platform_core.service.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll(Long id) {
        return projectRepository.findAllByOwner_Id(id);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project insert(Project project) {
        setInProgressStatus(project);
        return projectRepository.save(project);
    }

    @Override
    public void delete(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public Project update(Long id, Project project) {
        Project projectFromDB = findById(id);

        BeanUtils.copyProperties(project, project, "id");

        if(checkCrowdfundingDone(project.getCurrentFinancing(), project.getTotalFinancing()))
            setCrowdfundingDoneStatus(project);
        else
            setInProgressStatus(project);

        return projectRepository.save(projectFromDB);
    }

    @Override
    public boolean checkOwner(Long spnaId, Project project) {
        Long ownerId = project.getOwner().getId();
        return ownerId.equals(spnaId);
    }

    @Override
    public boolean checkCrowdfundingDone(Double currentFinancing, Double totalFinancing) {
        return currentFinancing.equals(totalFinancing);
    }

    @Override
    public void setInProgressStatus(Project project) {
        project.setProjectProgress(ProjectProgress.IN_PROGRESS);
    }

    @Override
    public void setCrowdfundingDoneStatus(Project project) {
        project.setProjectProgress(ProjectProgress.CROWDFUNDING_DONE);
    }

    @Override
    public void setFinishedStatus(Project project) {
        project.setProjectProgress(ProjectProgress.FINISHED);
    }

    @Override
    public void likesIncrement(Project project) {
        project.setDonationAmount(project.getDonationAmount() + 1);
    }

}
