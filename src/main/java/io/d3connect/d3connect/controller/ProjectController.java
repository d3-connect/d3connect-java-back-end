package io.d3connect.d3connect.controller;

import io.d3connect.d3connect.domain.Project;
import io.d3connect.d3connect.service.MapVaidator.MapValidationErrorService;
import io.d3connect.d3connect.service.ProjectService;
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

    /*
     *
     *
     *
     */

    @PostMapping("/projects/create")
    public ResponseEntity<?> createNewProject (@Valid @RequestBody Project project, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationErrorService(result);

        // Return errors
        if(errorMap != null) {
            return errorMap;
        }

        //Return successful project creation and an HTTP Status of 2XX
        Project projectSave =  projectService.createOrUpdateProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<?> findProjectIdentifier(@PathVariable String projectId) {
        Project project = projectService.findProjectIdentifier(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
