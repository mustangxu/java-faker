package com.github.javafaker;

public class Yoda {
    private final Faker faker;

    protected Yoda(final Faker faker) {
        this.faker = faker;
    }

    public String quote() {
        return this.faker.resolve("yoda.quotes");
    }
}
