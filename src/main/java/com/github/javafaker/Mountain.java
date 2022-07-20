package com.github.javafaker;

public class Mountain {
    private final Faker faker;

    protected Mountain(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("mountain.name", this, this.faker);
    }

    public String range() {
        return this.faker.fakeValuesService().resolve("mountain.range", this, this.faker);
    }
}
