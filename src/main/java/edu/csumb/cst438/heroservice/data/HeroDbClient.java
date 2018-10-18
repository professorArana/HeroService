package edu.csumb.cst438.heroservice.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.csumb.cst438.heroservice.api.entities.Hero;

@Repository
public class HeroDbClient {
    //TODO: use DB enteties rather than api layer enteties.
    public List<Hero> getHeroData () {
        //db validation
        //set up client
        //call the database
        //mapping
        //return to bus layer
        return null;
    }
}