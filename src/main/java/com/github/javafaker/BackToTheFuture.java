package com.github.javafaker;

public class BackToTheFuture {
    private final Faker faker;

    protected BackToTheFuture(Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return this.faker.resolve("back_to_the_future.characters");
    }

    public String date() {
        return this.faker.resolve("back_to_the_future.dates");
    }

    public String quote() {
        return this.faker.resolve("back_to_the_future.quotes");
    }
}
