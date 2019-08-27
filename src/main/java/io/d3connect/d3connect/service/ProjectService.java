package io.d3connect.d3connect.service;

import io.d3connect.d3connect.domain.Project;
import io.d3connect.d3connect.exception.ProjectUserException.CustomErrorException;
import io.d3connect.d3connect.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project createOrUpdateProject (Project project) {
        try {
            return projectRepository.save(project);
        } catch (Exception e) {
            throw  new CustomErrorException("ERROR Creating a project - " + project);
        }
    }
}
