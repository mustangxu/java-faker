package com.github.javafaker;

public class Ancient {

    private final Faker faker;

    protected Ancient(Faker faker) {
        this.faker = faker;
    }

    public String god() {
        return this.faker.resolve("ancient.god");
    }

    public String primordial() {
        return this.faker.resolve("ancient.primordial");
    }

    public String titan() {
        return this.faker.resolve("ancient.titan");
    }

    public String hero() {
        return this.faker.resolve("ancient.hero");
    }
}
