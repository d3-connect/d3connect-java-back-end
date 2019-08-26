package io.d3connect.d3connect.exception.ProjectException;

public class ProjectIdExceptionResponse {

    private String projectException;

    public ProjectIdExceptionResponse(String projectException) {
        this.projectException = projectException;
    }

    public String getProjectException() {
        return projectException;
    }

    public void setProjectException(String projectException) {
        this.projectException = projectException;
    }
}
