package com.adamvnuhus.ppmtool.exceptions;

/**
 * ppmtool
 *
 * @author anhdt
 * @created_at 11/02/2021 - 8:27 AM
 * @created_by anhdt
 * @since 11/02/2021
 */
public class ProjectIdExceptionResponse {

    private String projectIdentifier;

    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
