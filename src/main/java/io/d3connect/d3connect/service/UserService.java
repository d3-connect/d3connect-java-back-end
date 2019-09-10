package io.d3connect.d3connect.service;
import io.d3connect.d3connect.domain.User;
import io.d3connect.d3connect.exception.ProjectUserException.CustomErrorException;
import io.d3connect.d3connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //Create or Update User
    public User createOrUpdateUser(User user) {
        try {
            if(user.getId() != null) {
                //  project.setProjectBacklog(projectBacklogRepository.findByProjectIdentifier(project.getProjectIdentifier()));
                user.setUser(userRepository.findUserById(user.getId()));
            }
                return userRepository.save(user);

        } catch (Exception e) {
            throw new CustomErrorException("Username " + user.getUserName() + " already exists");
        }
    }

    // Find All Users
    public Iterable<User> findAllUsers() {
      return userRepository.findAll();
    }

    // STILL NEEDS TO RETURN ALL PROJECTS ATTACHED TO THE USER NAME
    // Find one user by Username
    public User findUsername(String username) {
        return userRepository.findByUserName(username);
    }



    // Delete User
    public void  deleteUserById(Long id) {
        User user  = userRepository.findUserById(id);
        userRepository.delete(user);
    }
}
