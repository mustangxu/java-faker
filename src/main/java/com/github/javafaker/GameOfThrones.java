package com.github.javafaker;

public class GameOfThrones {

    private final Faker faker;

    protected GameOfThrones(Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return this.faker.resolve("game_of_thrones.characters");
    }

    public String house() {
        return this.faker.resolve("game_of_thrones.houses");
    }

    public String city() {
        return this.faker.resolve("game_of_thrones.cities");
    }

    public String dragon() {
        return this.faker.resolve("game_of_thrones.dragons");
    }

    public String quote() {
      return this.faker.resolve("game_of_thrones.quotes");
    }
}
