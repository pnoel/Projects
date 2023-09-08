package org.pxdev.repository;

import org.pxdev.domain.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IProjectRepository extends CrudRepository<Project, UUID> {
}