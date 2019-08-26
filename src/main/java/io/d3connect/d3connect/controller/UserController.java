package io.d3connect.d3connect.controller;

import io.d3connect.d3connect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class UserController {

    @Autowired
    UserService userService;


}
