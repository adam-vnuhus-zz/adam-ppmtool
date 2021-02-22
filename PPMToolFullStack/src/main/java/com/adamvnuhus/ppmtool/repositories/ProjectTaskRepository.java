package com.adamvnuhus.ppmtool.repositories;

import com.adamvnuhus.ppmtool.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ppmtool
 *
 * @author anhdt
 * @created_at 19/02/2021 - 10:45 AM
 * @created_by anhdt
 * @since 19/02/2021
 */
@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

    List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);

    ProjectTask findByProjectSequence(String sequence);
}
