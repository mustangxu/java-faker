package com.github.javafaker;

public class Hobbit {
    private final Faker faker;

    protected Hobbit(Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return this.faker.fakeValuesService().resolve("hobbit.character", this, this.faker);
    }

    public String thorinsCompany() {
        return this.faker.fakeValuesService().resolve("hobbit.thorins_company", this, this.faker);
    }

    public String quote() {
        return this.faker.fakeValuesService().resolve("hobbit.quote", this, this.faker);
    }

    public String location() {
        return this.faker.fakeValuesService().resolve("hobbit.location", this, this.faker);
    }
}
