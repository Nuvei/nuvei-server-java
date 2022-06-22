package com.safecharge.model;

import javax.validation.Valid;

public class Verify3dCard extends CardData {

    @Valid
    private Verify3dThreeD threeD;

    public Verify3dThreeD getThreeD() {
        return threeD;
    }

    public void setThreeD(Verify3dThreeD threeD) {
        this.threeD = threeD;
    }
}
