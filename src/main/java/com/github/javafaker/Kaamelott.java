package com.github.javafaker;

public class Kaamelott {
    private final Faker faker;

    protected Kaamelott(Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return this.faker.fakeValuesService().resolve("kaamelott.characters", this, this.faker);
    }

    public String quote() {
        return this.faker.fakeValuesService().resolve("kaamelott.quotes", this, this.faker);
    }
}
