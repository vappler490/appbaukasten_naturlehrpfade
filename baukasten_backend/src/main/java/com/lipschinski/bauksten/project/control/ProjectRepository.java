package com.lipschinski.bauksten.project.control;

import com.lipschinski.bauksten.project.entities.ProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends MongoRepository<ProjectEntity, String> {

}
