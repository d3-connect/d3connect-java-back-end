package io.d3connect.d3connect.repository;

import io.d3connect.d3connect.domain.SocialLinks;
import org.springframework.data.repository.CrudRepository;

public interface SocialRepository extends CrudRepository<SocialLinks, Long> {
}
