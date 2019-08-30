package io.d3connect.d3connect.controller;

import io.d3connect.d3connect.domain.Project;
import io.d3connect.d3connect.domain.User;
import io.d3connect.d3connect.service.MapVaidator.MapValidationErrorService;
import io.d3connect.d3connect.service.ProjectService;
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
 */

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    //
    UserService userDao;


    /*
     *
     *
     *
     */

    @PostMapping("/projects/create")
    public ResponseEntity<?> createNewProject (@Valid @RequestBody Project project, User userId, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationErrorService(result);

        // Map and return errors
        if(errorMap != null) {
            return errorMap;
        }

        //Return successful project creation and an HTTP Status of 2XX
        Project projectSave =  projectService.createOrUpdateProject(project, userId);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }


    // Fetch one project through Project Identifier -> to Service Layer
    @GetMapping("/projects/{projectId}")
    public ResponseEntity<?> findProjectIdentifier(@PathVariable String projectId) {
        Project project = projectService.findProjectIdentifier(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
