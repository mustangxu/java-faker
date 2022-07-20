package com.github.javafaker;

public class University {
    private final Faker faker;

    protected University(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("university.name", this, this.faker);
    }

    public String prefix() {
        return this.faker.fakeValuesService().resolve("university.prefix", this, this.faker);
    }

    public String suffix() {
        return this.faker.fakeValuesService().resolve("university.suffix", this, this.faker);
    }
}
