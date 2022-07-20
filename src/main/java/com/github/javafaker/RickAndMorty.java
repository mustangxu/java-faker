package com.github.javafaker;

public class RickAndMorty  {
    private final Faker faker;

    protected RickAndMorty(final Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return this.faker.resolve("rick_and_morty.characters");
    }

    public String location() {
        return this.faker.resolve("rick_and_morty.locations");
    }

    public String quote() {
        return this.faker.resolve("rick_and_morty.quotes");
    }
}
