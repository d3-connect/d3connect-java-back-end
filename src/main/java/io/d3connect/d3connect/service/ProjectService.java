package io.d3connect.d3connect.service;

import io.d3connect.d3connect.domain.Project;
import io.d3connect.d3connect.domain.ProjectBacklog;
import io.d3connect.d3connect.domain.User;
import io.d3connect.d3connect.exception.ProjectUserException.CustomErrorException;
import io.d3connect.d3connect.repository.ProjectBacklogRepository;
import io.d3connect.d3connect.repository.ProjectRepository;
import io.d3connect.d3connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectBacklogRepository projectBacklogRepository;

    @Autowired
    UserRepository userRepository;


    /*
     *
     * Attach backlog to the created or updated project
     * Only create a new backlog IF the project is Null to indicate it's a new project
     * Pass project to the newly instantiated backlog to create the db relationship
     *
     */

    public Project createOrUpdateProject (Project project, User userId) {
        try {

            // Create a new backlog IF project is null
            if(project.getId() == null) {

                //Set user Id attached to the project
                ProjectBacklog projectBacklog = new ProjectBacklog();

                // Attach project Identifier and User Id to the project
                project.setProjectBacklog(projectBacklog);
                projectBacklog.setProject(project);
                projectBacklog.setProjectIdentifier(project.getProjectIdentifier());
                project.setUser(userRepository.findUserById(userId.getId()));
            }

            if(project.getId() != null) {
                project.setProjectBacklog(projectBacklogRepository.findByProjectIdentifier(project.getProjectIdentifier()));
                project.setUser(userRepository.findUserById(userId.getId()));
            }

            // Save project
            return projectRepository.save(project);

        } catch (Exception e) {
            throw  new CustomErrorException("Project Identifier " + project.getProjectIdentifier() + " already exists");
        }
    }

    /*
     *
     *  Fetch one project using Project Identifier
     *
     */
    public Project findProjectIdentifier(String projectId) {
        return projectRepository.findByProjectIdentifier(projectId);
    }
}
