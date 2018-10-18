package edu.csumb.cst438.heroservice.api.entities;

import java.util.List;

public class Powers {
    private List<String> powers;
    //TODO: Make List<String> to List<Power> where Power has a name/type and strength and maybe description...
    public Powers () {
        super();
    }
    public Powers (List<String> powers) {
        super();
        this.powers = powers;
    }

    public void setPowers (List<String> powers) {
        this.powers = powers;
    }

    public List<String> getPowers () {
        return this.powers;
    }

}