package com.lipschinski.bauksten.project.entities;


import com.lipschinski.bauksten.poi.entities.LatLng;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@TypeAlias("projects")
@Document(collection = "projects")
public class ProjectEntity {

  @Id
  private String _id;
  private String projectId;
  private String name;
  private LatLng center;
  private int zoom;

}

