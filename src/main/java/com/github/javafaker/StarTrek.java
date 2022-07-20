package com.github.javafaker;

public class StarTrek {
    private final Faker faker;

    protected StarTrek(Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return this.faker.fakeValuesService().resolve("star_trek.character", this, this.faker);
    }

    public String location() {
        return this.faker.fakeValuesService().resolve("star_trek.location", this, this.faker);
    }

    public String specie() {
        return this.faker.fakeValuesService().resolve("star_trek.specie", this, this.faker);
    }

    public String villain() {
        return this.faker.fakeValuesService().resolve("star_trek.villain", this, this.faker);
    }

    public String klingon() {
        return this.faker.fakeValuesService().resolve("star_trek.klingon", this, this.faker);
    }
}
