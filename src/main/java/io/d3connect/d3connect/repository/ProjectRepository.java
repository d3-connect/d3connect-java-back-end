package io.d3connect.d3connect.repository;

import io.d3connect.d3connect.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    // Interface for grabbing one project through Project Identifier
    Project findByProjectIdentifier(String projectId);

}
