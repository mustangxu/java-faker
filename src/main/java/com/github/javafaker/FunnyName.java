package com.github.javafaker;

public class FunnyName {
    private final Faker faker;

    protected FunnyName(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("funny_name.name", this, this.faker);
    }
}
