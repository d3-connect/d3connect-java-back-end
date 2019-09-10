package io.d3connect.d3connect.controller;

import io.d3connect.d3connect.domain.Comment;
import io.d3connect.d3connect.domain.User;
import io.d3connect.d3connect.service.CommentService;
import io.d3connect.d3connect.service.MapVaidator.MapValidationErrorService;
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
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    MapValidationErrorService mapValidationErrorService;


    /*
     *
     * Retrieve all user comments based on user Id
     *
     */
    @PostMapping("/user/comment/create")
    public ResponseEntity<?> retrieveUserComments(@Valid @RequestBody  Comment comment, User userId, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationErrorService(result);

        // Map and return errors
        if(errorMap != null) {
            return errorMap;
        }

        //
        Comment newOrUpdateComment = commentService.createOrUpdateComment(comment, userId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    /*
     *
     * Post user comments
     *
     */
    @GetMapping("/user/comment/show")
    public String saveUserComment() {
     return null;
    }


    /*
     * Get Project comments
     *
     */

    @GetMapping("/project/comments/{projectId}")
    public String retrieveProjectComments(@PathVariable Long projectId) {
        return null;
    }

    /*
     *
     *
     */
    @PostMapping("/project/comment/create")
    public String  saveProjectComment() {
        return null;
    }


}
