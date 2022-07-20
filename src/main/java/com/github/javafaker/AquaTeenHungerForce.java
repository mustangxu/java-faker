package com.github.javafaker;

public class AquaTeenHungerForce {

    private final Faker faker;

    protected AquaTeenHungerForce(Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return this.faker.fakeValuesService().resolve("aqua_teen_hunger_force.character", this, this.faker);
    }

}
