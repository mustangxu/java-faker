package com.github.javafaker;

public class Currency {

    private final Faker faker;

    public Currency(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("currency.name", this, this.faker);
    }

    public String code() {
        return this.faker.fakeValuesService().resolve("currency.code", this, this.faker);
    }
}
