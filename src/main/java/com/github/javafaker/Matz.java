package com.github.javafaker;

public class Matz {
    private final Faker faker;

    protected Matz(final Faker faker) {
        this.faker = faker;
    }

    public String quote() {
        return this.faker.resolve("matz.quotes");
    }
}
