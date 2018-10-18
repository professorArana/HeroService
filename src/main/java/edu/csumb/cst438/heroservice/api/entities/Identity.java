package edu.csumb.cst438.heroservice.api.entities;

public class Identity {
    private String name;
    //TODO: add more identity parameters (addr, dob, etc.)
    public Identity () {
        super();
    }
    public Identity (String name) {
        super();
        this.name = name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }
}