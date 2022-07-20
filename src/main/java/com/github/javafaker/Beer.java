package com.github.javafaker;

public class Beer {
    private final Faker faker;

    protected Beer(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("beer.name", this, this.faker);
    }

    public String style() {
        return this.faker.fakeValuesService().resolve("beer.style", this, this.faker);
    }

    public String hop() {
        return this.faker.fakeValuesService().resolve("beer.hop", this, this.faker);
    }

    public String yeast() {
        return this.faker.fakeValuesService().resolve("beer.yeast", this, this.faker);
    }

    public String malt() {
        return this.faker.fakeValuesService().resolve("beer.malt", this, this.faker);
    }
}
