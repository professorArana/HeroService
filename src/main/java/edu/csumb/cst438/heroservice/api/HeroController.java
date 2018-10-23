package edu.csumb.cst438.heroservice.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.csumb.cst438.heroservice.api.entities.Hero;
import edu.csumb.cst438.heroservice.api.entities.Identity;
import edu.csumb.cst438.heroservice.api.entities.AlterEgo;
import edu.csumb.cst438.heroservice.api.entities.Powers;
import edu.csumb.cst438.heroservice.business.Manager;

@RestController
public class HeroController {
    @Autowired
    Manager manager;

    @GetMapping ("/Heroes")
    @ResponseBody
    List<Hero> getHeroes () {
        Hero xavier = new Hero("1", new Identity("Charles Xavier"), new AlterEgo("Professor X"), new Powers(Arrays.asList("mind stuff")));
        Hero wolverine = new Hero("2", new Identity("James Howlett"), new AlterEgo("Wolverine"), new Powers(Arrays.asList("strength","rapid healing","metal bones")));
        Hero cyclops = new Hero("3", new Identity("Scott Summers"), new AlterEgo("Cyclops"), new Powers(Arrays.asList("eye beams")));
        List<Hero> result = Arrays.asList(xavier, wolverine, cyclops);
        // List<Hero> result = callDB();
        return result;
    }

    // private List<Hero> callDB () {
    //     String uri = "http://localhost:8081/allHeroes";
    //     RestTemplate restTemplate = new RestTemplate();
    //     ResponseEntity<List<Hero>> result = restTemplate.exchange(uri,
    //     HttpMethod.GET,null, 
    //     new ParameterizedTypeReference<List<Hero>>(){});
    //     return result.getBody();
    // }
}