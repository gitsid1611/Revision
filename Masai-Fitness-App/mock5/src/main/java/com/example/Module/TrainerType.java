package com.example.Module;

public enum TrainerType {

    Male("Personal"),
    Female("General");

    private String typ;

    private TrainerType(String typ) {
        this.typ = typ;
    }

    public String getTyp() {
        return typ;
    }
}
