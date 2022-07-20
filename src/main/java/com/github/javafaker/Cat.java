package com.github.javafaker;

public class Cat {

    private final Faker faker;

    protected Cat(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("creature.cat.name", this, this.faker);
    }

    public String breed() {
        return this.faker.fakeValuesService().resolve("creature.cat.breed", this, this.faker);
    }

    public String registry() {
        return this.faker.fakeValuesService().resolve("creature.cat.registry", this, this.faker);
    }
}
