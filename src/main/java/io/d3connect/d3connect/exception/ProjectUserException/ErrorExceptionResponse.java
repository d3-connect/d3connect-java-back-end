package io.d3connect.d3connect.exception.ProjectUserException;

public class ErrorExceptionResponse {

    private String errorException;

    public ErrorExceptionResponse(String errorException) {
        this.errorException = errorException;
    }

    public String getProjectException() {
        return errorException;
    }

    public void setProjectException(String errorException) {
        this.errorException = errorException;
    }
}
