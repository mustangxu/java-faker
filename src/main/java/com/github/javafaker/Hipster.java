package com.github.javafaker;

public class Hipster {
    private final Faker faker;

    protected Hipster(final Faker faker) {
        this.faker = faker;
    }

    public String word() {
        return this.faker.resolve("hipster.words");
    }
}
