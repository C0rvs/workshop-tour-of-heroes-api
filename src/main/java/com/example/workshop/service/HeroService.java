package com.example.workshop.service;

import com.example.workshop.model.Hero;
import com.example.workshop.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    @Autowired
    HeroRepository heroRepository;

    public String delete(Long id) {
        boolean isExist = exists(id);
        if (isExist) {
            heroRepository.deleteById(id);
            return "Deleted";
        }else {
            return "Error";
        }
    }

    public Hero update(Long id, Hero hero) {
        hero.setId(id);
        return heroRepository.save(hero);
    }

    public Hero create(Hero hero) {
        return heroRepository.save(hero);
    }

    public List<Hero> getAll() {
        List<Hero> heroes = new ArrayList<>();
        Iterable<Hero> iterable = heroRepository.findAll();
        iterable.forEach(heroes::add);
        return heroes;
    }

    private boolean exists(Long id) {
        Optional<Hero> product = heroRepository.findById(id);
        return product.isPresent();
    }

    public Optional<Hero> getHero(Long id){
        boolean isExist = exists(id);
        if(isExist){
            return heroRepository.findById(id);
        }
        return Optional.empty();
    }
}
