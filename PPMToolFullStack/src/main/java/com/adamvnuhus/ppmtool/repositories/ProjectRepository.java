package com.adamvnuhus.ppmtool.repositories;

import com.adamvnuhus.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ppmtool
 *
 * @author anhdt
 * @created_at 10/02/2021 - 10:28 PM
 * @created_by anhdt
 * @since 10/02/2021
 */
@Repository
public interface ProjectRepository  extends CrudRepository<Project, Long> {
}
