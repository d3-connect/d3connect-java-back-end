package io.d3connect.d3connect.service;

import io.d3connect.d3connect.domain.Comment;
import io.d3connect.d3connect.domain.User;
import io.d3connect.d3connect.exception.ProjectUserException.CustomErrorException;
import io.d3connect.d3connect.repository.CommentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRespository commentRespository;

    /*
     *
     *
     */
    public Comment createOrUpdateComment (Comment comment, User userId) {
        try {
            return commentRespository.save(comment);
        } catch (Exception e) {
            throw  new CustomErrorException("Unable to save comment");
        }
    }

    /*
     *
     *
     */
    public void deleteComment(Long id) {
        try {
            Comment comment = commentRespository.findCommentById(id);
            commentRespository.deleteById(comment);
        } catch (Exception e) {
            throw new CustomErrorException("Unable to delete comment " + e);
        }

    }
}
