package io.d3connect.d3connect.repository;

import io.d3connect.d3connect.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRespository extends CrudRepository<Comment, Long> {

}
