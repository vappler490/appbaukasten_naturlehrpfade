package com.lipschinski.bauksten.poi.boundary;


import com.lipschinski.bauksten.poi.control.PoiRepository;
import com.lipschinski.bauksten.poi.entities.Poi;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@RestController
@EnableWebMvc
@RequestMapping("/pois")
public class PoiController {

    private PoiRepository poiRepository;
    public PoiController(PoiRepository poiRepository
    ) {
        this.poiRepository = poiRepository;
    }

    @GetMapping(consumes = MediaType.ALL_VALUE)
    public List<Poi> getAllPois(
            @QuerydslPredicate(root = Poi.class) Predicate predicate
    ) {
        if (predicate == null) {
            return poiRepository.findAll();
        } else {
            return poiRepository.findAll(predicate);
        }
    }

    @GetMapping(path = "/{id}", consumes = MediaType.ALL_VALUE)
    public Optional<Poi> getById(@PathVariable("id") final String id) {
        return poiRepository.findById(id);
    }

    @GetMapping(path = "/projects", consumes = MediaType.ALL_VALUE)
    public List<String> getAllProjects() {
        return poiRepository.findAllProjects();
    }

    @PostMapping(consumes = MediaType.ALL_VALUE)
    public void createPoi(@RequestBody Poi poi) {
        poiRepository.save(poi);
        System.out.println(poi);
    }

    @DeleteMapping(path = "/delete/{id}", consumes = MediaType.ALL_VALUE)
    public void deletePoi(@PathVariable("id") final String id) {
        poiRepository.deleteById(id);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.ALL_VALUE)
    public void updatePoi(@RequestBody Poi poi, @PathVariable("id") final String id) {
        Optional<Poi> poiData = poiRepository.findByPoiId(id);
        Poi _poi = poiData.get();
        _poi.setHtmlData(poi.getHtmlData());
        _poi.setLastModified(poi.getLastModified());
        _poi.setName(poi.getName());
        poiRepository.save(_poi);
    }


}
