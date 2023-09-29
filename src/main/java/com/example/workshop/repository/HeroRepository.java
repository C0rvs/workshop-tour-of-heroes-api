package com.example.workshop.repository;

import com.example.workshop.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Long> {

    List<Hero> findByName(String name);
}
