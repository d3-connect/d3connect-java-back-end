package io.d3connect.d3connect.repository;

import io.d3connect.d3connect.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    //
    Project findByProjectIdentifier(String projectId);


}
