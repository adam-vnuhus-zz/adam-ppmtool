package com.adamvnuhus.ppmtool.controller;

import com.adamvnuhus.ppmtool.domain.Project;
import com.adamvnuhus.ppmtool.services.MapValidationErrorService;
import com.adamvnuhus.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ppmtool
 *
 * @author anhdt
 * @created_at 10/02/2021 - 10:31 PM
 * @created_by anhdt
 * @since 10/02/2021
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

   ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
    if(errorMap != null) return errorMap;

    projectService.saveOrUpdateProject(project);
    return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
}
