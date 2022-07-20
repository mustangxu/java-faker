package com.github.javafaker;

public class Bool {
    private final Faker faker;

    protected Bool(Faker faker) {
        this.faker = faker;
    }

    public boolean bool() {
        return this.faker.random().nextBoolean();
    }
}
