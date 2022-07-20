package com.github.javafaker;

public class Hacker {
    private final Faker faker;

    protected Hacker(Faker faker) {
        this.faker = faker;
    }

    public String abbreviation() {
        return this.faker.fakeValuesService().resolve("hacker.abbreviation", this, this.faker);
    }

    public String adjective() {
        return this.faker.fakeValuesService().resolve("hacker.adjective", this, this.faker);
    }

    public String noun() {
        return this.faker.fakeValuesService().resolve("hacker.noun", this, this.faker);
    }

    public String verb() {
        return this.faker.fakeValuesService().resolve("hacker.verb", this, this.faker);
    }

    public String ingverb() {
        return this.faker.fakeValuesService().resolve("hacker.ingverb", this, this.faker);
    }
}
