package io.d3connect.d3connect.controller;

import io.d3connect.d3connect.domain.User;
import io.d3connect.d3connect.service.MapVaidator.MapValidationErrorService;
import io.d3connect.d3connect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/*
 *
 *
 *
 *
 *
 */

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    // User Creation
    @PostMapping("/account/create")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationErrorService(result);

        // Return errors
        if(errorMap != null) {
            return errorMap;
        }

        User userCreate = userService.createOrUpdateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/account/user/{username}")
    public ResponseEntity<?> findUserByUsername(@PathVariable String username) {
        User user = userService.findUsername(username);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/account/user/delete/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long userId, BindingResult result) {

        return null;

    }

}
