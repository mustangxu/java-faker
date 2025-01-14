package com.github.javafaker;

public class RockBand {

    private final Faker faker;

    protected RockBand(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.resolve("rock_band.name");
    }
}
