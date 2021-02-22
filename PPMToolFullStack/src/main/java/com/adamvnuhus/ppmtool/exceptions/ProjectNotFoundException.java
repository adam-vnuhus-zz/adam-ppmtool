package com.adamvnuhus.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ppmtool
 *
 * @author anhdt
 * @created_at 20/02/2021 - 7:36 PM
 * @created_by anhdt
 * @since 20/02/2021
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectNotFoundException extends RuntimeException{

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
