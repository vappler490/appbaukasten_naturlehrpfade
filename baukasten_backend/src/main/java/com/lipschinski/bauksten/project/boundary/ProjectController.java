package com.lipschinski.bauksten.project.boundary;


import com.lipschinski.bauksten.project.control.ProjectRepository;
import com.lipschinski.bauksten.project.entities.ProjectEntity;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {

  private ProjectRepository projectRepository;

  public ProjectController(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @GetMapping(consumes = MediaType.ALL_VALUE)
  public List<ProjectEntity> getAll() {
    return projectRepository.findAll();
  }

  @PostMapping(consumes = MediaType.ALL_VALUE)
  public void createProject(@RequestBody ProjectEntity projectEntity) {
    projectRepository.save(projectEntity);
  }

}
