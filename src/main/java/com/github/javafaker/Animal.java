package com.github.javafaker;

public class Animal {
    private final Faker faker;

    protected Animal(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("creature.animal.name", this, this.faker);
    }
}
