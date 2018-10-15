package edu.csumb.cst438.heroservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.cst438.heroservice.api.entities.Hero;
import edu.csumb.cst438.heroservice.business.Manager;

@RestController
public class HeroController {
    @Autowired
    Manager manager;

    @GetMapping ("/Heroes")
    @ResponseBody
    List<Hero> getHeroes () {
        return null;
    }
}