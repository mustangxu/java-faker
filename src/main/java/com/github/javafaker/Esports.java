package com.github.javafaker;

public class Esports {
    private final Faker faker;

    protected Esports(final Faker faker) {
        this.faker = faker;
    }

    public String player() {
        return this.faker.resolve("esport.players");
    }

    public String team() {
        return this.faker.resolve("esport.teams");
    }

    public String event() {
        return this.faker.resolve("esport.events");
    }

    public String league() {
        return this.faker.resolve("esport.leagues");
    }

    public String game() {
        return this.faker.resolve("esport.games");
    }
}
