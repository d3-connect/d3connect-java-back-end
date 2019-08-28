package io.d3connect.d3connect.service;

import io.d3connect.d3connect.domain.Project;
import io.d3connect.d3connect.domain.ProjectBacklog;
import io.d3connect.d3connect.exception.ProjectUserException.CustomErrorException;
import io.d3connect.d3connect.repository.ProjectBacklogRepository;
import io.d3connect.d3connect.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectBacklogRepository projectBacklogRepository;


    public Project createOrUpdateProject (Project project) {
        try {

            /*
             *
             * Attach backlog to the created or updated project
             * Only create a new backlog IF the project is Null to indicate it's a new project
             * Pass project to the newly instantiated backlog to create the db relationship
             *
             */

            if(project.getId() == null) {
                ProjectBacklog projectBacklog = new ProjectBacklog();
                project.setProjectBacklog(projectBacklog);
                projectBacklog.setProject(project);
                projectBacklog.setProjectIdentifier(project.getProjectIdentifier());
            }

            if(project.getId() != null) {
                project.setProjectBacklog(projectBacklogRepository.findByProjectIdentifier(project.getProjectIdentifier()));
            }

            return projectRepository.save(project);
        } catch (Exception e) {
            throw  new CustomErrorException("ERROR in Creating a project - Project Identifier already exists for - " + project);
        }
    }
}
