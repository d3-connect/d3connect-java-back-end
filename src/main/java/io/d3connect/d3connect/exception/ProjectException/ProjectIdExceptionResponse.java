package io.d3connect.d3connect.exception.ProjectException;

public class ProjectIdExceptionResponse {

    private Long projectId;

    public ProjectIdExceptionResponse(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
