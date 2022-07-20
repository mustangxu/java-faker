package com.github.javafaker;

public class Overwatch {
    private final Faker faker;

    protected Overwatch(Faker faker) {
        this.faker = faker;
    }

    public String hero() {
        return this.faker.fakeValuesService().resolve("games.overwatch.heroes", this, this.faker);
    }

    public String location() {
        return this.faker.fakeValuesService().resolve("games.overwatch.locations", this, this.faker);
    }

    public String quote() {
        return this.faker.fakeValuesService().resolve("games.overwatch.quotes", this, this.faker);
    }
}
