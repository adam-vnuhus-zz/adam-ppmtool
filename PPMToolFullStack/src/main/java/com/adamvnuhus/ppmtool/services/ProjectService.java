package com.adamvnuhus.ppmtool.services;

import com.adamvnuhus.ppmtool.domain.Project;
import com.adamvnuhus.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ppmtool
 *
 * @author anhdt
 * @created_at 10/02/2021 - 10:04 PM
 * @created_by anhdt
 * @since 10/02/2021
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        return projectRepository.save(project);
    }
}
