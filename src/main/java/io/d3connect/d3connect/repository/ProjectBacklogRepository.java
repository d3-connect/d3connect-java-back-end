package io.d3connect.d3connect.repository;

import io.d3connect.d3connect.domain.ProjectBacklog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectBacklogRepository extends CrudRepository<ProjectBacklog, Long> {
}
