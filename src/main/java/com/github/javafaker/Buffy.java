package com.github.javafaker;

public class Buffy {
    private final Faker faker;

    protected Buffy(Faker faker) {
        this.faker = faker;
    }

    public String characters() {
        return this.faker.fakeValuesService().resolve("buffy.characters", this, this.faker);
    }

    public String quotes() {
        return this.faker.fakeValuesService().resolve("buffy.quotes", this, this.faker);
    }

    public String celebrities() {
        return this.faker.fakeValuesService().resolve("buffy.celebrities", this, this.faker);
    }

    public String bigBads() {
        return this.faker.fakeValuesService().resolve("buffy.big_bads", this, this.faker);
    }

    public String episodes() {
        return this.faker.fakeValuesService().resolve("buffy.episodes", this, this.faker);
    }

}
