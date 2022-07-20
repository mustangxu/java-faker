package com.github.javafaker;

public class Superhero {
    private final Faker faker;

    protected Superhero(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("superhero.name", this, this.faker);
    }

    public String prefix() {
        return this.faker.fakeValuesService().resolve("superhero.prefix", this, this.faker);
    }

    public String suffix() {
        return this.faker.fakeValuesService().resolve("superhero.suffix", this, this.faker);
    }

    public String power() {
        return this.faker.fakeValuesService().resolve("superhero.power", this, this.faker);
    }

    public String descriptor() {
        return this.faker.fakeValuesService().resolve("superhero.descriptor", this, this.faker);
    }
}
