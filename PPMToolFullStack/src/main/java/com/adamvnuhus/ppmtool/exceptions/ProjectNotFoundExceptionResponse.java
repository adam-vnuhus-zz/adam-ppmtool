package com.adamvnuhus.ppmtool.exceptions;

/**
 * ppmtool
 *
 * @author anhdt
 * @created_at 20/02/2021 - 7:32 PM
 * @created_by anhdt
 * @since 20/02/2021
 */
public class ProjectNotFoundExceptionResponse {

    private String ProjectNotFound;

    public ProjectNotFoundExceptionResponse(String projectNotFound){
        ProjectNotFound = projectNotFound;
    }

    public String getProjectNotFound() {
        return ProjectNotFound;
    }

    public void setProjectNotFound(String projectNotFound) {
        ProjectNotFound = projectNotFound;
    }
}
