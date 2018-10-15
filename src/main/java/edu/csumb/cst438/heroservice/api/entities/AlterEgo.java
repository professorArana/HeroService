package edu.csumb.cst438.heroservice.api.entities;

public class AlterEgo {
    private String name;
    //TODO: add more identity parameters (titles, etc.)

    public AlterEgo (String name) {
        this.name = name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }
}