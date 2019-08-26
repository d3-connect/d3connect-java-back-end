package io.d3connect.d3connect.repository;

import io.d3connect.d3connect.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {



    // Find All Users
    @Override
    Iterable<User> findAll();

    // Find user by Id
    User findUserById(Long id);

    // Find user by username
    User findByUserName(String username);
}
