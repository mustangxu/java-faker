package com.github.javafaker;

public class Lebowski {
    private final Faker faker;

    public Lebowski(final Faker faker) {
        this.faker = faker;
    }

    public String actor() {
        return this.faker.fakeValuesService().resolve("lebowski.actors", this, this.faker);
    }

    public String character() {
        return this.faker.fakeValuesService().resolve("lebowski.characters", this, this.faker);
    }

    public String quote() {
        return this.faker.fakeValuesService().resolve("lebowski.quotes", this, this.faker);
    }
}
