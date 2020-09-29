package com.lipschinski.bauksten.poi.control;

import com.lipschinski.bauksten.poi.entities.Poi;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PoiRepository extends MongoRepository<Poi, String>,
    QuerydslPredicateExecutor<Poi> {


  List<Poi> findAll();
  List<Poi> findAll(Predicate predicate);
  @Query(value = "{distinct: 'pois', key: 'project'}", fields = "{ 'project' : 1, '_id': 1}")
  List<String> findAllProjects();
  Optional <Poi> findByPoiId(String id);
}
