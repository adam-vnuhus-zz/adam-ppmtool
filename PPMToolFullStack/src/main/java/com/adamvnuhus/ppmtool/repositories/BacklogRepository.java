package com.adamvnuhus.ppmtool.repositories;

import com.adamvnuhus.ppmtool.domain.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ppmtool
 *
 * @author anhdt
 * @created_at 19/02/2021 - 10:44 AM
 * @created_by anhdt
 * @since 19/02/2021
 */
@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {

    Backlog findByProjectIdentifier(String Identifier);
}
