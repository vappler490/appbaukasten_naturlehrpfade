package com.lipschinski.bauksten.poi.entities;

import java.time.LocalDateTime;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@TypeAlias("pois")
@Document(collection = "pois")
public class Poi {
  @Id
  private String id;
  private String poiId;
  private String name;
  private String htmlData;
  private LatLng latLng;
  private String project;
  private String author;
  private boolean poiIsStored;
  private LocalDateTime lastModified = LocalDateTime.now();

}
