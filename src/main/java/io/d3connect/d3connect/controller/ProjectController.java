package io.d3connect.d3connect.controller;

import io.d3connect.d3connect.domain.Project;
import io.d3connect.d3connect.service.MapVaidator.MapValidationErrorService;
import io.d3connect.d3connect.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping("/new")
    public ResponseEntity<?> createNewProject (@Valid @RequestBody Project project, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationErrorService(result);

        // Return errors
        if(errorMap != null) {
            return errorMap;
        }

        //Return successful project creation and an HTTP Status of 2XX
        Project projectSave = projectService.createOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
}
