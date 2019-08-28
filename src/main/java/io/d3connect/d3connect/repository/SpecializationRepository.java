package io.d3connect.d3connect.repository;

import io.d3connect.d3connect.domain.Specialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends CrudRepository<Specialization, Long> {

}
