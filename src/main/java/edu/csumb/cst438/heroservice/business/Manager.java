package edu.csumb.cst438.heroservice.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.cst438.heroservice.api.entities.Hero;
import edu.csumb.cst438.heroservice.data.HeroDbClient;

@Service
public class Manager {
    @Autowired
    HeroDbClient heroDbClient;

    //TODO: use Business entities rather than api/presentation layer enteties.
    public List<Hero> getHeroList () {
        //do some business validation
        //call the data layer
        //data validation
        //return data from data layer
        return null;
    }
}