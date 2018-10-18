package edu.csumb.cst438.heroservice.business;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import edu.csumb.cst438.heroservice.api.entities.AlterEgo;
import edu.csumb.cst438.heroservice.api.entities.Hero;
import edu.csumb.cst438.heroservice.api.entities.Identity;
import edu.csumb.cst438.heroservice.api.entities.Powers;
import edu.csumb.cst438.heroservice.data.HeroDbClient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerTester {

    @Autowired
    Manager manager;

    @MockBean
    HeroDbClient heroDb;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getHeroListReturnsEmptyListWhenNullHeroesInDb () {
        when(heroDb.getHeroData()).thenReturn(null);
        Assert.assertEquals(null, manager.getHeroList());
        
    }

    @Test
    public void getHeroListReturnsExpectedResults () {
        when(heroDb.getHeroData()).thenReturn(FiveStandardHerosStub());
        List<Hero> expectedHeroes = FiveStandardHerosStub();
        List<Hero> actualHeroes = manager.getHeroList();
        // todo: use library or manually implement equals() for list-to-list .equals() comarison
        Assert.assertTrue(expectedHeroes.get(1).getIdentity().getName().equals(
            actualHeroes.get(1).getIdentity().getName()));
    }

    @Test
    public void getHeroListPercolatesExceptionWhenThrownAtLowerLevel () {
        when(heroDb.getHeroData()).thenThrow(new RuntimeException("Test"));
        expectedException.expect(RuntimeException.class);
        manager.getHeroList();
    }

    private List<Hero> FiveStandardHerosStub () {
        List<Hero> result = new ArrayList<Hero>();
        Hero h1 = new Hero("1", new Identity("1"), new AlterEgo("a"), new Powers(Arrays.asList("l","m","o")));
        Hero h2 = new Hero("2", new Identity("2"), new AlterEgo("b"), new Powers(Arrays.asList("l","m","o")));
        Hero h3 = new Hero("3", new Identity("3"), new AlterEgo("c"), new Powers(Arrays.asList("l","m","o")));
        Hero h4 = new Hero("4", new Identity("4"), new AlterEgo("d"), new Powers(Arrays.asList("l","m","o")));
        Hero h5 = new Hero("5", new Identity("5"), new AlterEgo("e"), new Powers(Arrays.asList("l","m","o")));
        result = Arrays.asList(h1,h2,h3,h4,h5);
        return result;
    }

    /* What to test Answers from class:

    //Right: manager returns expected results

    //Boundry Test - Error: exception bubbles up

    //boundry test - Error: database connection failure
    
    //boundry test - type or mapping error... misc database error.

    //boundry test - Existance: what happens if there are no heroes

    //boundry test - Range: too many heroes?

    //boundry test - range: no more than 10 heroes are returned at once.

    //performance test: obtain list of 1000 in less than 2 seconds

    //Boundry - conformance: what if hero has no alter ego
    //Boundry - conformance: what if hero has no Identity

    //Boundry - conformance: what if hero has no powers
    */
}