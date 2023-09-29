package com.example.workshop.controller;

import com.example.workshop.model.Hero;
import com.example.workshop.service.HeroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HeroServiceController {

    @Autowired
    HeroService heroService;

    @DeleteMapping(value = "/heroes/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(heroService.delete(id),HttpStatus.OK);
    }

    @PutMapping(value = "/heroes/{id}")
    public ResponseEntity<Object> updateHero(@PathVariable("id") Long id, @RequestBody Hero hero) {
        return new ResponseEntity<>(heroService.update(id, hero), HttpStatus.OK);
    }

    @PostMapping(value = "/heroes")
    public ResponseEntity<Object> createHero(@RequestBody Hero hero) {
        return new ResponseEntity<>(heroService.create(hero), HttpStatus.CREATED);
    }

    @GetMapping(value = "/heroes")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> getHero() {
        return new ResponseEntity<>(heroService.getAll(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/heroes/{id}")
    public ResponseEntity<Object> getHeroWithId(@PathVariable("id") Long id){
        return new ResponseEntity<>(heroService.getHero(id), HttpStatus.OK);
    }
}