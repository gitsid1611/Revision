package com.example.Module;

public enum Gender {
    Male("Male"),
    Female("Female");

    private String gen;

    private Gender(String gen) {
        this.gen = gen;
    }

    public String getGen() {
        return gen;
    }
}
